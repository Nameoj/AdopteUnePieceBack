package fr.adopteunepiece.adope_une_piece.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adopteunepiece.adope_une_piece.entities.MotoBrand;
import fr.adopteunepiece.adope_une_piece.entities.MotoCylinder;
import fr.adopteunepiece.adope_une_piece.entities.MotoYear;
import fr.adopteunepiece.adope_une_piece.repositories.MotoCylinderRepository;

@RestController
@RequestMapping("/api/cylinder")
public class CylinderController {
	
	@Autowired
	MotoCylinderRepository cylinderRepository;
	
	@PostMapping("/postcylinder")
	public MotoCylinder addCylinder(@RequestBody MotoCylinder theCylinder) {
		MotoCylinder _cylinder=cylinderRepository.save(new MotoCylinder(theCylinder.getCylinderName(), theCylinder.getMotoModels(), theCylinder.getMotoYears()));
		return _cylinder;
	}
	
	@GetMapping("/allcylinders")
	public List<MotoCylinder> allBrands(){
		List<MotoCylinder> allCylinders = this.cylinderRepository.findAll();
		return allCylinders;
	}
	
	@PutMapping("/{cylinderName}")
	public MotoCylinder updateCylinder(@PathVariable("cylinderName") String name, @RequestBody MotoCylinder motoCylinder) {
		MotoCylinder _motoCylinder = cylinderRepository.findById(name).get();
		
		_motoCylinder.setCylinderName(motoCylinder.getCylinderName());
		_motoCylinder.setMotoModels(motoCylinder.getMotoModels());
		_motoCylinder.setMotoYears(motoCylinder.getMotoYears());
		
		return cylinderRepository.save(_motoCylinder);
	}
}