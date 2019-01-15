package fr.adopteunepiece.adope_une_piece.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
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
import fr.adopteunepiece.adope_une_piece.entities.Seller;
import fr.adopteunepiece.adope_une_piece.entities.User;
import fr.adopteunepiece.adope_une_piece.repositories.RoleRepository;
import fr.adopteunepiece.adope_une_piece.repositories.SellerRepository;
import fr.adopteunepiece.adope_une_piece.repositories.UserRepository;
import fr.adopteunepiece.adope_une_piece.security.jwt.JwtProvider;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SellerController {
	
	@Autowired
	private SellerRepository sellerDao;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;
 
	@Autowired
	RoleRepository roleRepository;
 
	@Autowired
	PasswordEncoder encoder;
 
	@Autowired
	JwtProvider jwtProvider;
	
	Map<String, String> errors;
	
	
	@PostMapping("/signup/seller")
	public ResponseEntity<?> registerSeller(@RequestBody Seller theSeller) {

		User u = sellerDao.findByEmail(theSeller.getEmail());
		
		if(u!=null) {
			return new ResponseEntity<>( HttpStatus.CONFLICT);
		}
		
		theSeller.setId(0L);
		Seller _seller = new Seller(theSeller.getUsername(), encoder.encode(theSeller.getPassword()), theSeller.getRaisonSociale(), theSeller.getAdresse1(), theSeller.getAdresse2(), 
				theSeller.getCodePostal(), theSeller.getVille(), theSeller.getTelephone(), theSeller.getSiren(),
				theSeller.getEmail(),theSeller.getNomG(), theSeller.getPrenomG(), theSeller.getTelephoneG());
		
		
		 Set<Role> strRoles = roleRepository.findByName(RoleName.ROLE_SELLER);
		
		_seller.setRoles(strRoles);
		
		sellerDao.save(_seller);
 
		return new ResponseEntity<>(_seller, HttpStatus.OK);
	}
	
	@GetMapping("/sellers")
	public List<Seller> getAllSellers() {
		return sellerDao.findAll();
	}
	
	@GetMapping("/seller/{username}")
	public ResponseEntity<User> getSellerDetails(@PathVariable("username") String username){
	
		User sellerDetails = sellerDao.findByEmail(username);
		
		return new ResponseEntity<>(sellerDetails, HttpStatus.OK);
	}
	
	@PutMapping("/update/{username}")
	public ResponseEntity<User> updateCustomer(@PathVariable("username") String username, @RequestBody Seller seller) {
		System.out.println("Update Seller with ID = " + username + "...");

		Optional<Seller> sellerId = sellerDao.findByUsername(username);
		
		
		if (sellerId.isPresent()) {
			Seller _seller = sellerId.get();
			_seller.setRaisonSociale(seller.getRaisonSociale());
			_seller.setAdresse1(seller.getAdresse1());
			_seller.setAdresse2(seller.getAdresse2());
			_seller.setCodePostal(seller.getCodePostal());
			_seller.setVille(seller.getVille());
			_seller.setTelephone(seller.getTelephone());
			_seller.setSiren(seller.getSiren());
			_seller.setEmail(seller.getEmail());
			_seller.setNomG(seller.getNomG());
			_seller.setPrenomG(seller.getPrenomG());
			_seller.setTelephoneG(seller.getTelephoneG());
			_seller.setUsername(seller.getUsername());
			
			return new ResponseEntity<>(sellerDao.save(_seller), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/updatemdp/{username}")
	public ResponseEntity<User> updateCustomerMdp(@PathVariable("username") String username, @RequestBody Seller seller) {
		System.out.println("Update Seller with ID = " + username + "...");

		Optional<Seller> sellerId = sellerDao.findByUsername(username);
		
		
		if (sellerId.isPresent()) {
			Seller _seller = sellerId.get();
			_seller.setPassword(encoder.encode(seller.getPassword()));
			
			return new ResponseEntity<>(sellerDao.save(_seller), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
