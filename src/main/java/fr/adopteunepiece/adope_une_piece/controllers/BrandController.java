package fr.adopteunepiece.adope_une_piece.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adopteunepiece.adope_une_piece.entities.MotoBrand;
import fr.adopteunepiece.adope_une_piece.entities.MotoModel;
import fr.adopteunepiece.adope_une_piece.repositories.MotoBrandRepository;

@RestController
@RequestMapping("/api/brand")
public class BrandController {
	
	@Autowired
	MotoBrandRepository brandRepository;
	
	@PostMapping("/postbrand")
	public MotoBrand addBrand(@RequestBody MotoBrand theBrand) {
		List<MotoModel> models = theBrand.getMotoModels();
		if (models == null) models = new ArrayList<>();
		MotoBrand _brand=brandRepository.save(new MotoBrand(theBrand.getName(), models));
		return _brand;
	}
	
	@GetMapping("/allbrands")
	public List<MotoBrand> allBrands(){
		List<MotoBrand> allBrands = this.brandRepository.findAll();
		return allBrands;
	}
	
	@GetMapping("/{name}")
	public MotoBrand oneBrand(@PathVariable("name") String name) {
		return brandRepository.findById(name).get();
	}
}
