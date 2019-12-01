package com.lhq.postmanagermentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhq.postmanagermentservice.feignfroxy.LandServiceProxy;
import com.lhq.postmanagermentservice.model.Land;
import com.lhq.postmanagermentservice.model.Post;
import com.lhq.postmanagermentservice.model.PostLand;
import com.lhq.postmanagermentservice.repository.PostRepository;

@RestController
@RequestMapping("/post/land")
public class GetLandController {
	
	
	@Autowired LandServiceProxy landProxy;
	
	@Autowired PostRepository postRepo;
	
	@GetMapping("/{id}")
	public PostLand getFullPost(@PathVariable("id") Long id){
		Post post = postRepo.findById(id).get();
		//Long getPostId = post.getPost_id();
		//int postId = getPostId.intValue();
		Long landId = (long) post.getLand_id();
		Land reponse = landProxy.getLandById(landId);

		return new PostLand(post.getPost_id(),
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
				reponse.getFacade_area());
		}
}
