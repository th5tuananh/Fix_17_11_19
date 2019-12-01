package com.lhq.ultilityservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhq.ultilityservice.model.Ultility;
import com.lhq.ultilityservice.repository.UltilityRepository;

@RestController
@RequestMapping("/api")
public class MainController {

	@Autowired UltilityRepository ulRepo;
	
	
	@GetMapping("/{id}")
	public List<String> getUltiPerHouse(@PathVariable("id") int houseId){
		
		List<String> list = new ArrayList<>();
		
		List<Ultility> allUlti = ulRepo.findByHouseId(houseId);
		for(Ultility ulti : allUlti) {
			String ultiName = ulti.getName();
			list.add(ultiName);
		}
		
		return list;
	}
	
	@PostMapping("/")
	public Ultility addNewUl(@RequestBody Ultility ulti) {
		
		return ulRepo.save(ulti);
	}
	
}
