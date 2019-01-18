package fr.adopteunepiece.adope_une_piece.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adopteunepiece.adope_une_piece.entities.Announce;
import fr.adopteunepiece.adope_une_piece.entities.Seller;
import fr.adopteunepiece.adope_une_piece.repositories.AnnounceDao;
import fr.adopteunepiece.adope_une_piece.repositories.BuyerRepository;
import fr.adopteunepiece.adope_une_piece.repositories.SellerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AnnounceController {
	
	@Autowired
	private AnnounceDao announceDao;
	
	@Autowired
	private SellerRepository sellerDao;
	
	// add mapping for POST custommer add a new customer
	@PostMapping("/announces/postAnnounce")
	public Announce addAnnounce(@RequestBody Announce theAnnounce) {
	
	Seller seller = sellerDao.findByEmail(theAnnounce.getSeller());
	
	theAnnounce.setId(0);
	Announce _announce = announceDao.save(new Announce(seller, theAnnounce.getSeller(), theAnnounce.getImage(), 
			theAnnounce.getDescription(), theAnnounce.getNote(), theAnnounce.getPostDate(), theAnnounce.getPrice(), theAnnounce.getCharge(),
			theAnnounce.getPieceName(), theAnnounce.getModel(), theAnnounce.getYear(), theAnnounce.getBrand(), theAnnounce.getCylinder()));

		return  _announce;
	}

	
	@PutMapping("/announces/{id}")
	public ResponseEntity<Object> updateAnnounce(@PathVariable("id") Long id) {
		System.out.println("Update Announce with ID = " + id + "...");

		Optional<Announce> announceId = this.announceDao.findById(id);
		
		
		if (announceId.isPresent()) {
			Announce _announce = announceId.get();
			_announce.setSeller(_announce.getSeller());
			_announce.setImage(_announce.getImage());
			_announce.setDescription(_announce.getDescription());
			_announce.setNote(_announce.getNote());
			_announce.setPostDate(_announce.getPostDate());
			_announce.setPrice(_announce.getPrice());
			_announce.setCharge(_announce.getCharge());
			_announce.setPieceName(_announce.getPieceName());
			_announce.setModel(_announce.getModel());
			_announce.setYear(_announce.getYear());
			_announce.setBrand(_announce.getBrand());
			_announce.setCylinder(_announce.getCylinder());
			return new ResponseEntity<>(announceDao.save(_announce), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/announces")
	public List<Announce> allAnnounces(){
		List<Announce> listAnnouncesValide = new ArrayList<Announce>();

		List<Announce> listAnnounces = announceDao.findAll();
		
		for(Announce announce : listAnnounces) {
			if (announce.getActive()== true) {
				listAnnouncesValide.add(announce);
				}
			}
		return listAnnouncesValide;
		}
	
	@GetMapping("/announces/{id}")
	public Announce oneAnnounce(@PathVariable("id") Long id) {
		return this.announceDao.findById(id).get();
	}
	
	@GetMapping("/deleteannounces/{id}")
	public void deleteAnnounce(@PathVariable("id") Long id) {
		Announce _announce=this.announceDao.findById(id).get();
		_announce.setActive(false);
		announceDao.save(_announce);
		}

	@GetMapping("/announces/seller/{seller}")
	public List<Announce> announcesBySeller(@PathVariable("seller") String seller){
		List<Announce> announcesBySeller=this.announceDao.findBySeller(seller);
		List<Announce> listAnnoncesSellerValides = new ArrayList<Announce>();

		for(Announce announce :announcesBySeller) {
			if (announce.getActive()== true) {
				listAnnoncesSellerValides.add(announce);
				}
			}

		return listAnnoncesSellerValides;
	}
}
