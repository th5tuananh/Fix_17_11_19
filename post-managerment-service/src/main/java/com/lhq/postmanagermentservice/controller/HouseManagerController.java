package com.lhq.postmanagermentservice.controller;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhq.postmanagermentservice.feignfroxy.HomeServiceProxy;
import com.lhq.postmanagermentservice.feignfroxy.UltilityServiceProxy;
import com.lhq.postmanagermentservice.model.House;
import com.lhq.postmanagermentservice.model.HouseCata;
import com.lhq.postmanagermentservice.model.Post;
import com.lhq.postmanagermentservice.model.PostRent;
import com.lhq.postmanagermentservice.model.Ultility;
import com.lhq.postmanagermentservice.repository.PostRepository;

@RestController
@RequestMapping("/personal")
public class HouseManagerController {

	@Autowired
	HomeServiceProxy homeProxy;
	
	@Autowired
	PostRepository postRepo;
	
	@Autowired UltilityServiceProxy ultiProxy;
	
	@GetMapping("/{id}")
	public List<HouseCata> getPersonalHouseList(@PathVariable("id") String userId){
		
		List<HouseCata> houseCata = new ArrayList<>();
		List<House> allHouse = homeProxy.getPersonalHouse(userId);
		for(House house : allHouse) {
			HouseCata item = new HouseCata(house.getHouse_id(), house.getHouse_name(),house.getAddress());
			Link link = ControllerLinkBuilder.linkTo(PersonalHouse.class).slash(house.getHouse_id()).withSelfRel();
			item.add(link);
			houseCata.add(item);
		}
		
		return houseCata;
	}
	@PutMapping("/house/{id}")
	public House editHouse(@PathVariable("id") Long id, @RequestBody House house) {

		return homeProxy.editHouse(id, house);
	}
	@PostMapping("/house")
	public House addNewPerHouse(@RequestBody House house) {
		
		return homeProxy.addHouse(house);
	}
	
	@PostMapping("/{house_id}/post")
	public String addNewPostPerHouse(@PathVariable("house_id") int houseId, @RequestBody PostRent post) {
		
		List<String> listUlti = post.getUlti();
		for(String item : listUlti) {
			Ultility ulti = new Ultility((long) 0,houseId, item, "none");
			ultiProxy.addUlti(ulti);
		}
		
		postRepo.save(new Post(
				(long) 0,
				post.getUser_id(), 
				houseId, 0, 
				"rent", 
				post.getTitle(),
				post.getContent(), 
				post.getPrice(), 
				post.getThumbnail(), 
				post.getArea(), 
				post.getCity(), 
				post.getDistrict(), 
				post.getLocation(), 
				post.getCertification(), 
				post.getRating(), 
				"inactive" ));
		
		return "Created";
	}
	
}
