package com.lhq.postmanagermentservice.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhq.postmanagermentservice.feignfroxy.UserManaServiceProxy;
import com.lhq.postmanagermentservice.model.Favorite;
import com.lhq.postmanagermentservice.model.PostCata;
import com.lhq.postmanagermentservice.repository.PostCataRepository;

@RestController
@RequestMapping("/userfavorite")
public class UserController {

	
	@Autowired
	UserManaServiceProxy userProxy;
	
	@Autowired
	PostCataRepository cataRepo;
	

	
	@GetMapping("/{id}")
	public List<PostCata> getListFavoFerUser(@PathVariable("id") String id){
		List<PostCata> perFavo = new ArrayList<PostCata>();
		List<Favorite> allFavorite = userProxy.getFavobyPostId(id);
		for(Favorite favorite : allFavorite) {
			Long postId = (long)favorite.getPost_id();
			PostCata postCata = cataRepo.findByPostId(postId);
			String cata = postCata.getCatalog();
			if(cata.equals("house")) {
			Link selfLink = ControllerLinkBuilder.linkTo(GetHouseController.class).slash(postId).withSelfRel();
			postCata.add(selfLink);
			}else {
				Link selfLink = ControllerLinkBuilder.linkTo(GetLandController.class).slash(postId).withSelfRel();
				postCata.add(selfLink);
			}
			perFavo.add(postCata);
		}
		return perFavo;
	}
	
	@PostMapping("/")
	public Favorite addfavo(@RequestBody Favorite favo) {
		return userProxy.addFavo(favo);
	}
}
