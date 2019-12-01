package com.lhq.postmanagermentservice.controller;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lhq.postmanagermentservice.feignfroxy.HomeServiceProxy;
import com.lhq.postmanagermentservice.feignfroxy.LandServiceProxy;
import com.lhq.postmanagermentservice.repository.PostCataRepository;
import com.lhq.postmanagermentservice.repository.PostRepository;
import com.lhq.postmanagermentservice.model.PostCata;
import com.lhq.postmanagermentservice.model.PostHouse;
import com.lhq.postmanagermentservice.model.PostLand;
import com.lhq.postmanagermentservice.model.House;
import com.lhq.postmanagermentservice.model.Land;
import com.lhq.postmanagermentservice.model.Post;

@RestController
public class MainController {
	@Autowired PostCataRepository postCataRepo;
	
	@Autowired HomeServiceProxy homeProxy;
	
	@Autowired LandServiceProxy landProxy;
	
	@Autowired PostRepository postRepo;
	
	
	
	@GetMapping("/post")
	public List<PostCata> getAll(){
		
		List<PostCata> allPostCata = postCataRepo.findByCatalog("land", "house");
		for (PostCata postCata : allPostCata) {
			Long postId = postCata.getPost_id();
			String cata = postCata.getCatalog();
			if(cata.equals("house")) {
			Link selfLink = ControllerLinkBuilder.linkTo(GetHouseController.class).slash(postId).withSelfRel();
			postCata.add(selfLink);
			}else {
				Link selfLink = ControllerLinkBuilder.linkTo(GetLandController.class).slash(postId).withSelfRel();
				postCata.add(selfLink);
			}
		}
		return allPostCata;
	}

	/*@GetMapping("/post/{id}")
	public Post getFullPostById(@PathVariable("id") Long post_id) {
		Post post = postRepo.findById(post_id).get();
		if (post.getHouse_id() != 0) {
			House house = homeProxy.getHouseById(((long) post.getHouse_id()));
			return new PostHouse();
		}
	}*/
	
	@GetMapping("/post/{city}")
	public List<PostCata> getByCity(@PathVariable("city") String city){
		String city1 = city.replace("-", " ");
		List<PostCata> listByCity = new ArrayList<>();
		List<PostCata> allPostCata = postCataRepo.findByCatalog("land", "house");
		for (PostCata postCata : allPostCata) {
			Long postId = postCata.getPost_id();
			String city2 = postCata.getCity();
			
			String city3 = unAccent(city2);
			String cata = postCata.getCatalog();
				if(city3.equals(city1)) {
					if(cata.equals("house")) {
						Link selfLink = ControllerLinkBuilder.linkTo(GetHouseController.class).slash(postId).withSelfRel();
						postCata.add(selfLink);
						}else {
							Link selfLink = ControllerLinkBuilder.linkTo(GetLandController.class).slash(postId).withSelfRel();
							postCata.add(selfLink);
						}
					listByCity.add(postCata);
				}
			}
		
		return listByCity;
	}
	@GetMapping("/post/{city}/{dictrist}")
	public List<PostCata> getByDictrist(@PathVariable("city") String city, @PathVariable("dictrist") String dict){
		/*String city1 = city.replace("-", " ");
		String dict1 = dict.replace("-", " ");
		List<PostCata> listByCity = new ArrayList<>();
		List<PostCata> allPostCata = postCataRepo.findByCatalog("land", "house");
		for (PostCata postCata : allPostCata) {
			Long postId = postCata.getPost_id();
			String city2 = unAccent(postCata.getCity());
			String dict2 = unAccent(postCata.getDistrict());
			String cata = postCata.getCatalog();
				if(city2.equals(city1) && dict2.equals(dict1)) {
					if(cata.equals("house")) {
						Link selfLink = ControllerLinkBuilder.linkTo(GetHouseController.class).slash(postId).withSelfRel();
						postCata.add(selfLink);
						}else {
							Link selfLink = ControllerLinkBuilder.linkTo(GetLandController.class).slash(postId).withSelfRel();
							postCata.add(selfLink);
						}
					listByCity.add(postCata);
				}
			}*/
		
		return postCataRepo.findPostCataByCityAndDistrict(city, dict);
	}
	@GetMapping("/personal/post/{id}")
	public List<PostCata> getPesonalPost(@PathVariable("id") String userId){
		return postCataRepo.findByUserId(userId);
	}
	
	
	@PostMapping("/post/land/")
	public Post addNewLandPost(@RequestBody PostLand post) {
		//int max = postRepo.max();
		//int val = max+1;
		int max = landProxy.getMaxLandValue();
		int val = max+1;
		
			Land land = new Land((long ) 0 ,post.getUser_id(), post.getImage_url(), post.getAddress(), post.getDirection(), post.getFacade_area());
			landProxy.addLand(land);
		Post postbody = new Post(
				(long) 0,
				post.getUser_id(),
				0,
				val,
				post.getCatalog(),
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
				"inactive");
		return postRepo.save(postbody);
			
	}
	@PostMapping("/post/house/")
	public Post addNewHousePost(@RequestBody PostHouse post) {
		//int max = postRepo.max();
		//int val = max+1;
		//String cata = post.getCatalog();
		int max = homeProxy.getMaxHouseValue();
		int val = max+1;
			House house = new House((long ) 0 ,post.getUser_id(),"none", post.getHouse_level(),post.getFloor(), post.getBedroom(), post.getRestroom(), post.getImage_url(), post.getAddress(), post.getDirection());
			homeProxy.addHouse(house);
		Post postbody = new Post(
				(long) 0,
				post.getUser_id(),
				val,
				0,
				post.getCatalog(),
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
				"inactive");
		return postRepo.save(postbody);
			
	}
	
	@PutMapping("/admin/post/{id}")
	public Post editPost(@PathVariable("id") Long id, @Valid @RequestBody Post post){
		
		return postRepo.save(post);
	}
	
	public static String unAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replace("đ", "").toLowerCase();
}
	
}
