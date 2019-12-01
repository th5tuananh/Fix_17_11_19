package com.lhq.postmanagermentservice.feignfroxy;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lhq.postmanagermentservice.model.Land;
@FeignClient(name="land-service", url="localhost:8004")
public interface LandServiceProxy {
	
		
		@GetMapping("/api/land/{id}")
		public Land getLandById(@PathVariable("id") long id);
		
		//@GetMapping("/api/land")
		//public List<PostCata> getallLand();
		
		@PostMapping("/api/land/")
		Land addLand(@Valid @RequestBody Land land);
		
		@GetMapping("/api/land/post/{id}")
		public Land getLandbyPostId(@PathVariable("id") int postId);
	
		@GetMapping("/api/land/max")
		public int getMaxLandValue();
}