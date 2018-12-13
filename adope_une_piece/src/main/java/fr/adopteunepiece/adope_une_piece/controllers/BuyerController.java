package fr.adopteunepiece.adope_une_piece.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	// add mapping for POST custommer add a new customer
	@PostMapping("/buyers")
	public Buyer addCustomer(@RequestBody Buyer theBuyer) {
		
		theBuyer.setId(0);
		Buyer _buyer = buyerDao.save(new Buyer(theBuyer.getEmail(), theBuyer.getPassword(), theBuyer.getCivilite(), theBuyer.getPrenom(), 
				theBuyer.getNom(), theBuyer.getTelephone(), theBuyer.getAdresse1(), theBuyer.getAdresse2(), 
				theBuyer.getCodepostal(), theBuyer.getVille(), theBuyer.getActive()));
		
		return _buyer;
	}
	

}
