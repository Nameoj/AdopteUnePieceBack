package fr.adopteunepiece.adope_une_piece.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adopteunepiece.adope_une_piece.entities.MotoBrand;
import fr.adopteunepiece.adope_une_piece.entities.MotoModel;
import fr.adopteunepiece.adope_une_piece.repositories.MotoBrandRepository;

@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController
@RequestMapping("/api/brand")
public class BrandController {
	
	@Autowired
	MotoBrandRepository brandRepository;
	
	@PostMapping("/post")
	public MotoBrand addBrand(@RequestBody MotoBrand theBrand) {
		List<MotoModel> models = theBrand.getMotoModels();
		if (models == null) models = new ArrayList<>();
		MotoBrand _brand=brandRepository.save(new MotoBrand(theBrand.getName(), models));
		return _brand;
	}
	
	@PutMapping("/put/{name}")
	public MotoBrand updateBrand(@PathVariable("name") String name, @RequestBody MotoBrand motoBrand) {
		MotoBrand _motoBrand = brandRepository.findById(name).get();
		
		_motoBrand.setMotoModels(motoBrand.getMotoModels());
		_motoBrand.setName(name);
		
		return brandRepository.save(_motoBrand);
	}
	
	@GetMapping("/get/all")
	public List<MotoBrand> allBrands(){
		List<MotoBrand> allBrands = this.brandRepository.findAll();
		return allBrands;
	}
	
	@GetMapping("/get/{name}")
	public MotoBrand oneBrand(@PathVariable("name") String name) {
		return brandRepository.findById(name).get();
	}
}
