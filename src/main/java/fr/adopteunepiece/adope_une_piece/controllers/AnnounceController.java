package fr.adopteunepiece.adope_une_piece.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adopteunepiece.adope_une_piece.entities.Announce;
import fr.adopteunepiece.adope_une_piece.repositories.AnnounceDao;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AnnounceController {
	
	@Autowired
	private AnnounceDao announceDao;
	
	// add mapping for POST custommer add a new customer
	@PostMapping("/announces-pro")
	public Announce addCostomer(@RequestBody Announce theAnnounce) {
	
	theAnnounce.setId(0);
	Announce _announce = announceDao.save(new Announce(theAnnounce.getTitle(), theAnnounce.getSeller(), theAnnounce.getImage(), 
			theAnnounce.getDescription(), theAnnounce.getNote(), theAnnounce.getPostDate(), theAnnounce.getPrice()));
		return  _announce;
	}

}
