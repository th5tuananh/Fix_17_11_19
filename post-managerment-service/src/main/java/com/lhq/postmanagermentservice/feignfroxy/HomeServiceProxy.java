package com.lhq.postmanagermentservice.feignfroxy;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lhq.postmanagermentservice.config.HouseClientConfig;
import com.lhq.postmanagermentservice.model.House;

@FeignClient(name="house-service", url="localhost:8005", configuration = HouseClientConfig.class)
public interface HomeServiceProxy {
	
	
	@GetMapping("/api/house/post/{id}")
	public House getHousebyPostId(@PathVariable("id") int postId);
	
	@GetMapping("/api/house/{id}")
	public House getHouseById(@PathVariable("id") Long id);
	
	
	@PostMapping("/api/house/")
	House addHouse(@Valid @RequestBody House house); 
	
	@GetMapping("/api/house/max")
	public int getMaxHouseValue();
	
	@GetMapping("/api/personal/house/{id}")
	public List<House> getPersonalHouse(@PathVariable("id") String user_id);
	
	@PutMapping("/api/house/{id}")
	public House editHouse(@PathVariable("id") Long id, @RequestBody House house);
}
