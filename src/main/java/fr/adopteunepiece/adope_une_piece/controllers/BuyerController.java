package fr.adopteunepiece.adope_une_piece.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import fr.adopteunepiece.adope_une_piece.entities.Buyer;
import fr.adopteunepiece.adope_une_piece.repositories.BuyerDao;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BuyerController {
	
	@Autowired
	private BuyerDao buyerDao;
	
	Map<String, String> errors;
	
	// add mapping for POST buyer add a new buyer
	@PostMapping("/buyers")
	public ResponseEntity<Object> addCustomer(@RequestBody Buyer theBuyer) {
		
		Buyer u = buyerDao.findByEmail(theBuyer.getEmail());
		
		if(u!=null) {
			return new ResponseEntity<>( HttpStatus.CONFLICT);
		}
		
		theBuyer.setId(0);
		Buyer _buyer = buyerDao.save(new Buyer(theBuyer.getEmail(), theBuyer.getPassword(), theBuyer.getCivilite(), theBuyer.getPrenom(), 
				theBuyer.getNom(), theBuyer.getTelephone(), theBuyer.getAdresse1(), theBuyer.getAdresse2(), 
				theBuyer.getCodepostal(), theBuyer.getVille(), theBuyer.getActive()));
		
		return new ResponseEntity<>(_buyer, HttpStatus.OK);
	}
	
	@PutMapping("/buyers/{id}")
	public ResponseEntity<Buyer> updateCustomer(@PathVariable("id") long id, @RequestBody Buyer buyer) {
		System.out.println("Update Buyer with ID = " + id + "...");

		Optional<Buyer> buyerId = buyerDao.findById(id);
		
		Buyer u = buyerDao.findByEmail(buyer.getEmail());
		
		if(u!=null && u.getId()!=id) {
			return new ResponseEntity<>( HttpStatus.CONFLICT);
		}

		if (buyerId.isPresent()) {
			Buyer _buyer = buyerId.get();
			_buyer.setEmail(buyer.getEmail());
			_buyer.setPassword(buyer.getPassword());
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
	//@PostMapping("/buyer/connection")
	//public ResponseEntity<String> buyerConnection(@RequestBody BuyerConnection theBuyerConnection){
		
	//	Buyer u = buyerDao.findByEmail(theBuyerConnection.getEmail)
		
	//}
	
	

}
