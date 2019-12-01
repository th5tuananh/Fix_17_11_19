package com.lhq.postmanagermentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhq.postmanagermentservice.feignfroxy.HomeServiceProxy;
import com.lhq.postmanagermentservice.model.House;
import com.lhq.postmanagermentservice.model.Post;
import com.lhq.postmanagermentservice.model.PostHouse;
import com.lhq.postmanagermentservice.repository.PostRepository;

@RestController
@RequestMapping("/post/house")
public class GetHouseController {

	
	@Autowired HomeServiceProxy homeProxy;
	
	@Autowired PostRepository postRepo;
	
	
	@GetMapping("/{id}")
	public PostHouse getFullPost(@PathVariable("id") Long id){
		Post post = postRepo.findById(id).get();
		//Long getPostId = post.getPost_id();
		//int postId = getPostId.intValue();
		Long houseId = (long) post.getHouse_id();
		House reponse = homeProxy.getHouseById(houseId);

		return new PostHouse(post.getPost_id(),
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
				post.getCertification(),
				reponse.getDirection(),
				post.getRating(),
				reponse.getHouse_level(),
				reponse.getFloor(),
				reponse.getRestroom(),
				reponse.getBedroom());
		}
	

}
