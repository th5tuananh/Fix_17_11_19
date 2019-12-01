package com.lhq.houseservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhq.houseservice.exception.ResourceNotFoundException;
import com.lhq.houseservice.model.House;
import com.lhq.houseservice.repository.HouseRepository;

@RestController
@RequestMapping("/api")
public class HouseController {
	
	@Autowired
	HouseRepository houseRepo;

	
	@GetMapping("/house/{id}")
	public House getHouse(@PathVariable("id") long landId){

		return houseRepo.findById(landId).orElseThrow(() -> new ResourceNotFoundException("House", "id", landId));
	}
	
	@PutMapping("/house/{id}")
	public House edithouse(@PathVariable("id") Long houseId, @RequestBody House house) {
		
		
		return houseRepo.save(house);
	}
	@GetMapping("/house/max")
	public int getMax() {
		int maxNum;
		maxNum = houseRepo.max();
		return maxNum;
	}
	
	@GetMapping("/personal/house/{id}")
	public List<House> getPerHouse(@PathVariable("id") String id){
		List<House> houseList = new ArrayList<>();
		List<House> allHouse = houseRepo.findPersonalHouse(id);
		for(House house : allHouse) {
			String houseName = house.getHouse_name();
			if(!houseName.equals("none")) {
				houseList.add(house);
			}
		}
		
		return houseList;
	}
	
	@PostMapping("/house/")
	public House addHouse(@Valid @RequestBody House home) {
		return houseRepo.save(home);
	}
	
}