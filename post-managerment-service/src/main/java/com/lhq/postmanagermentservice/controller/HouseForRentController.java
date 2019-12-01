package com.lhq.postmanagermentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhq.postmanagermentservice.feignfroxy.HomeServiceProxy;
import com.lhq.postmanagermentservice.feignfroxy.UltilityServiceProxy;
import com.lhq.postmanagermentservice.model.House;
import com.lhq.postmanagermentservice.model.Post;
import com.lhq.postmanagermentservice.model.PostCata;
import com.lhq.postmanagermentservice.model.PostHouse;
import com.lhq.postmanagermentservice.model.PostRent;
import com.lhq.postmanagermentservice.repository.PostCataRepository;
import com.lhq.postmanagermentservice.repository.PostRepository;

@RestController
@RequestMapping("/post/rent")
public class HouseForRentController {

	@Autowired PostRepository postRepo;
	
	@Autowired HomeServiceProxy homeProxy;
	
	@Autowired UltilityServiceProxy ulProxy;
	
	@Autowired PostCataRepository postCataRepo;
	
	@GetMapping("/{id}")
	public PostRent getHouseForRent(@PathVariable("id") Long postId) {
		
		Post post = postRepo.findById(postId).get();
		int houseId = post.getHouse_id();
		Long houseId1 = (long) houseId;
		House reponse = homeProxy.getHouseById(houseId1);
		List<String> ulti = ulProxy.getUlti(houseId);
		
		PostRent rent = new PostRent(post.getPost_id(),
				post.getUser_id(),
				post.getCatalog(),
				post.getTitle(),
				post.getContent(),
				post.getPrice(),
				post.getArea(),
				post.getThumbnail(),
				reponse.getImage_url(),
				post.getCity(),
				post.getDistrict(),
				reponse.getAddress(),
				post.getLocation(),
				post.getRating(),
				ulti
				);
		Link link1 = ControllerLinkBuilder.linkTo(RoomManager.class).slash(houseId).withRel("getroom");
		rent.add(link1);

		return rent;
	}
	
	@GetMapping("/")
	public List<PostCata> getAll(){
		
		List<PostCata> allPostCata = postCataRepo.findRentByCatalog("rent");
		for (PostCata postCata : allPostCata) {
			Long postId = postCata.getPost_id();
			String cata = postCata.getCatalog();
			
			Link selfLink = ControllerLinkBuilder.linkTo(HouseForRentController.class).slash(postId).withSelfRel();
			postCata.add(selfLink);
			
		}
		return allPostCata;
	}
}
