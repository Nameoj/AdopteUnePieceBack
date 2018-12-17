package fr.adopteunepiece.adope_une_piece.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adopteunepiece.adope_une_piece.entities.Seller;
import fr.adopteunepiece.adope_une_piece.repositories.SellerDao;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SellerController {

	@Autowired
	private SellerDao sellerDao;
	
	// add mapping for POST seller add a new seller
	@PostMapping("/sellers")
	public Seller addBuyer(@RequestBody Seller theSeller) {
		
		theSeller.setId(0);
		Seller _seller = sellerDao.save(new Seller(theSeller.getEmail(), theSeller.getPassword(), theSeller.getRaisonSociale(), 
				theSeller.getSiretNumber(), theSeller.getSirenNumber(), theSeller.getTelephone(), theSeller.getAdresse(),
				theSeller.getCodepostal(), theSeller.getVille(), theSeller.getManagingDirectorName(),
				theSeller.getManagingDirectorSurname(), theSeller.getManagingDirectorPhone(), theSeller.getActive()));
		
		return _seller;
	}
	
}
