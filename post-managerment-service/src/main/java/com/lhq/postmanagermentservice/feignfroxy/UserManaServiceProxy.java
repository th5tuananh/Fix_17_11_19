package com.lhq.postmanagermentservice.feignfroxy;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lhq.postmanagermentservice.model.Favorite;



@FeignClient(name="user-service", url="localhost:8006")
public interface UserManaServiceProxy {
	@PostMapping("/favorite")
	Favorite addFavo(@Valid @RequestBody Favorite favo);
	
	@GetMapping("/favorite/{id}")
	public List<Favorite> getFavobyPostId(@PathVariable("id") String user_id);
}
