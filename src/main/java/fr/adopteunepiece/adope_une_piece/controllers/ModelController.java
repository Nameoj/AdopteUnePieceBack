package fr.adopteunepiece.adope_une_piece.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import fr.adopteunepiece.adope_une_piece.entities.MotoModel;
import fr.adopteunepiece.adope_une_piece.repositories.MotoModelRepository;

@RestController
@RequestMapping("/api/model")
public class ModelController {
	
	@Autowired
	MotoModelRepository modelRepository;
	
	@PostMapping("/postmodel")
	public MotoModel addModel(@RequestBody MotoModel theModel) {
		Set<MotoCylinder> cylinders = theModel.getMotoCylinders();
		if (cylinders == null) cylinders = new HashSet<>();
		MotoModel _models=modelRepository.save(new MotoModel(theModel.getModelName(), theModel.getMotoBrand(), cylinders));
		return _models;
	}
	
	@GetMapping("/allmodels")
	public List<MotoModel> allBrands(){
		List<MotoModel> allModels = this.modelRepository.findAll();
		return allModels;
	}
	
	@PutMapping("/{modelName}")
	public MotoModel updateCylinder(@PathVariable("modelName") String modelName, @RequestBody MotoModel motoModel) {
		MotoModel _motoModel = modelRepository.findById(modelName).get();
		
		_motoModel.setModelName(motoModel.getModelName());
		_motoModel.setMotoBrand(motoModel.getMotoBrand());
		_motoModel.setMotoCylinders(motoModel.getMotoCylinders());
		
		return modelRepository.save(_motoModel);
	}
	
}
