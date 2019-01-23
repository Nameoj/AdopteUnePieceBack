package fr.adopteunepiece.adope_une_piece.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adopteunepiece.adope_une_piece.entities.MotoModel;
import fr.adopteunepiece.adope_une_piece.entities.MotoModelInfo;
import fr.adopteunepiece.adope_une_piece.repositories.MotoModelInfoRepository;
import fr.adopteunepiece.adope_une_piece.repositories.MotoModelRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/modelinfo")
public class ModelInfoController {
	
	@Autowired
	MotoModelInfoRepository modelInfoRepository;
	
	@PostMapping("/post")
	public MotoModelInfo addModel(@RequestBody MotoModelInfo infoModel) {
		MotoModelInfo _infomodels=modelInfoRepository.save(new MotoModelInfo(infoModel.getMotoModel(),infoModel.getMotoCylinder(), infoModel.getMotoYear()));
		return _infomodels;
	}
	
	@GetMapping("/get/all")
	public List<MotoModelInfo> allModels(){
		List<MotoModelInfo> allInfoModels = this.modelInfoRepository.findAll();
		return allInfoModels;
	}
	
	@GetMapping("/get/{model}")
	public List<MotoModelInfo> allModel(@PathVariable("model") MotoModel motoModel){
		List<MotoModelInfo> allInfoModels = this.modelInfoRepository.findByMotoModel(motoModel);
		return allInfoModels;
	}
	
	@PutMapping("/put/{modelInfoId}")
	public MotoModelInfo updateModel(@PathVariable("modelInfoId") Long id, @RequestBody MotoModelInfo motoModelInfo) {
		MotoModelInfo _motoModel = modelInfoRepository.findById(id).get();
		
		_motoModel.setId(motoModelInfo.getId());
		_motoModel.setMotoCylinder(motoModelInfo.getMotoCylinder());
		_motoModel.setMotoModel(motoModelInfo.getMotoModel());
		_motoModel.setMotoYear(motoModelInfo.getMotoYear());
		
		
		return modelInfoRepository.save(_motoModel);
	}
	
}
