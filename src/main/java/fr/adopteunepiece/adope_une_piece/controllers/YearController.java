package fr.adopteunepiece.adope_une_piece.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adopteunepiece.adope_une_piece.entities.MotoCylinder;
import fr.adopteunepiece.adope_une_piece.entities.MotoModel;
import fr.adopteunepiece.adope_une_piece.entities.MotoYear;
import fr.adopteunepiece.adope_une_piece.repositories.MotoModelRepository;
import fr.adopteunepiece.adope_une_piece.repositories.MotoYearRepository;

@RestController
@RequestMapping("/api/year")
public class YearController {
	
	@Autowired
	MotoYearRepository yearRepository;
	
	@PostMapping("/postyear")
	public MotoYear addYear(@RequestBody MotoYear theYear) {
		System.out.println("Year : " + theYear.getYearName() + " // cylinder : " + theYear.getMotoCylinders().iterator().next().getCylinderName());
		MotoYear _year=yearRepository.save(new MotoYear(theYear.getYearName(), theYear.getMotoCylinders()));
		return _year;
	}
	@GetMapping("/allyears")
	public List<MotoYear> allBrands(){
		List<MotoYear> allYears = this.yearRepository.findAll();
		return allYears;
	}
	
}