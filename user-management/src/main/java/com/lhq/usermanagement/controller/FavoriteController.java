package com.lhq.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lhq.usermanagement.model.Favorite;
import com.lhq.usermanagement.repository.FavoriteRepository;

@RestController
public class FavoriteController {

	@Autowired
	FavoriteRepository favoRepo;
	
	@GetMapping("/favorite/{id}")
	public List<Favorite> getPersonFavo(@PathVariable("id") String user_id) {
		
		return favoRepo.findByUserId(user_id);
	}
	
	@PostMapping("/favorite")
	public Favorite addPersonFavo(@RequestBody Favorite favo) {
		
		return favoRepo.save(favo);
	}
}
