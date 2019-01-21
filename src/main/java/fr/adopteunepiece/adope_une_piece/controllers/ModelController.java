package fr.adopteunepiece.adope_une_piece.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adopteunepiece.adope_une_piece.entities.MotoBrand;
import fr.adopteunepiece.adope_une_piece.entities.MotoModel;
import fr.adopteunepiece.adope_une_piece.repositories.MotoModelRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/model")
public class ModelController {
	
	@Autowired
	MotoModelRepository modelRepository;
	
	@PostMapping("/post")
	public MotoModel addModel(@RequestBody MotoModel theModel) {
		MotoModel _models=modelRepository.save(new MotoModel(theModel.getModelName(), theModel.getMotoBrand(), theModel.getMotoModelInfo()));
		return _models;
	}
	
	@GetMapping("/get/all")
	public List<MotoModel> allModels(){
		List<MotoModel> allModels = this.modelRepository.findAll();
		return allModels;
	}
	
//	@GetMapping("/get/{motoBrand}")
//	public List<MotoModel> modelsByBrand(@PathVariable("motoBrand") MotoBrand motoBrand){
//		List<MotoModel> modelsByBrand = this.modelRepository.findByMotoBrand(motoBrand);
//		return modelsByBrand;
//	}
	
	@PutMapping("/put/{modelName}")
	public MotoModel updateModel(@PathVariable("modelName") String modelName, @RequestBody MotoModel motoModel) {
		MotoModel _motoModel = modelRepository.findById(modelName).get();
		
		_motoModel.setModelName(motoModel.getModelName());
		_motoModel.setMotoBrand(motoModel.getMotoBrand());
		_motoModel.setMotoModelInfo(motoModel.getMotoModelInfo());
		
		return modelRepository.save(_motoModel);
	}
	
}
