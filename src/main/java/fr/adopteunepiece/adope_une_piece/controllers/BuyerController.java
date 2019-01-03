package fr.adopteunepiece.adope_une_piece.controllers;



import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import fr.adopteunepiece.adope_une_piece.entities.Role;
import fr.adopteunepiece.adope_une_piece.entities.RoleName;
import fr.adopteunepiece.adope_une_piece.entities.User;
import fr.adopteunepiece.adope_une_piece.repositories.RoleRepository;
import fr.adopteunepiece.adope_une_piece.repositories.UserRepository;
import fr.adopteunepiece.adope_une_piece.security.jwt.JwtProvider;
import fr.adopteunepiece.adope_une_piece.security.jwt.JwtResponse;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BuyerController {
	
	@Autowired
	private UserRepository buyerDao;
	
	@Autowired
	AuthenticationManager authenticationManager;
 
	@Autowired
	RoleRepository roleRepository;
 
	@Autowired
	PasswordEncoder encoder;
 
	@Autowired
	JwtProvider jwtProvider;
	
	Map<String, String> errors;
	
	// add mapping for POST buyer add a new buyer
	@PostMapping("/buyers")
	public ResponseEntity<Object> addCustomer(@RequestBody User theBuyer) {
		
		User u = buyerDao.findByEmail(theBuyer.getEmail());
		
		if(u!=null) {
			return new ResponseEntity<>( HttpStatus.CONFLICT);
		}
		
		theBuyer.setId(0L);
	//	User _buyer = buyerDao.save(new User(theBuyer.getEmail(), theBuyer.getPassword(), theBuyer.getCivilite(), theBuyer.getPrenom(), 
	//			theBuyer.getNom(), theBuyer.getTelephone(), theBuyer.getAdresse1(), theBuyer.getAdresse2(), 
	//			theBuyer.getCodepostal(), theBuyer.getVille(), theBuyer.getActive()));
		
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody User theBuyer) {

		User u = buyerDao.findByEmail(theBuyer.getEmail());
		
		if(u!=null) {
			return new ResponseEntity<>( HttpStatus.CONFLICT);
		}
		
		// Creating user's account
		//User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				//encoder.encode(signUpRequest.getPassword()));
		
		theBuyer.setId(0L);
		User _buyer = new User(theBuyer.getEmail(), encoder.encode(theBuyer.getPassword()), theBuyer.getUsername(), theBuyer.getCivilite(), theBuyer.getPrenom(), 
				theBuyer.getNom(), theBuyer.getTelephone(), theBuyer.getAdresse1(), theBuyer.getAdresse2(), 
				theBuyer.getCodepostal(), theBuyer.getVille(), theBuyer.getActive());
 
//		Set<Role> strRoles = theBuyer.getRoles();
//		Set<Role> roles = new HashSet<>();
// 
//		strRoles.forEach(role -> {
//			switch (role) {
//			case "admin":
//				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
//						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
//				roles.add(adminRole);
// 
//				break;
//			case "seller":
//				Role sellerRole = roleRepository.findByName(RoleName.ROLE_SELLER)
//						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
//				roles.add(sellerRole);
// 
//				break;
//			default:
//				Role buyerRole = roleRepository.findByName(RoleName.ROLE_BUYER)
//						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
//				roles.add(buyerRole);
//			}
//		});
		
		Set<Role> strRoles = roleRepository.findByName(RoleName.ROLE_BUYER);
		
		_buyer.setRoles(strRoles);
		
		buyerDao.save(_buyer);
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(theBuyer.getUsername(), theBuyer.getPassword()));
 
		SecurityContextHolder.getContext().setAuthentication(authentication);
 
		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
 
		return new ResponseEntity<>(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()), HttpStatus.OK);
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody User theBuyer) {
 
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(theBuyer.getUsername(), theBuyer.getPassword()));
 
		SecurityContextHolder.getContext().setAuthentication(authentication);
 
		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
 
		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}
	
	@GetMapping("/buyer/{username}")
	public ResponseEntity<User> getBuyerDetails(@PathVariable("username") String username){
	
		User buyerDetails = buyerDao.findByEmail(username);
		
		return new ResponseEntity<>(buyerDetails, HttpStatus.OK);
	}
		
	@PutMapping("/buyer/{username}")
	public ResponseEntity<User> updateCustomer(@PathVariable("username") String username, @RequestBody User buyer) {
		System.out.println("Update Buyer with ID = " + username + "...");

		Optional<User> buyerId = buyerDao.findByUsername(username);
		
		
		if (buyerId.isPresent()) {
			User _buyer = buyerId.get();
			_buyer.setEmail(buyer.getEmail());
			_buyer.setUsername(buyer.getUsername());
			_buyer.setPassword(encoder.encode(buyer.getPassword()));
			_buyer.setCivilite(buyer.getCivilite());
			_buyer.setPrenom(buyer.getPrenom());
			_buyer.setNom(buyer.getNom());
			_buyer.setTelephone(buyer.getTelephone());
			_buyer.setAdresse1(buyer.getAdresse1());
			_buyer.setAdresse2(buyer.getAdresse2());
			_buyer.setCodepostal(buyer.getCodepostal());
			_buyer.setVille(buyer.getVille());
			
			return new ResponseEntity<>(buyerDao.save(_buyer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
