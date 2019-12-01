package com.lhq.landservice.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhq.landservice.exception.ResourceNotFoundException;
import com.lhq.landservice.model.Land;
import com.lhq.landservice.repository.LandRepository;

@RestController
@RequestMapping("/api")
public class LandController {

	@Autowired
	LandRepository landRepository;
	
	
	@GetMapping("/land/{id}")
	public Land getLand(@PathVariable("id") long landId){

		return landRepository.findById(landId).orElseThrow(() -> new ResourceNotFoundException("Land", "id", landId));
	}
	/*@GetMapping("/land/post/{id}")
	public Land getLandbyPostId(@PathVariable("id") int postId) {
		return landRepository.findByPostId(postId);
	}*/
	
	@GetMapping("/land/max")
	public int getMax() {
		int maxNum;
		maxNum = landRepository.max();
		return maxNum;
	}
	
	@PostMapping("/land/")
	public Land addLand(@Valid @RequestBody Land home) {
		return landRepository.save(home);
	}
	
	
}
