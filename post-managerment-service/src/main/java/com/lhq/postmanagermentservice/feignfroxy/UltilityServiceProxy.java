package com.lhq.postmanagermentservice.feignfroxy;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lhq.postmanagermentservice.model.Ultility;




@FeignClient(name="ultility-service", url="localhost:8007")
public interface UltilityServiceProxy {

	@GetMapping("/api/{id}")
	public List<String> getUlti(@PathVariable("id") int id);
	
	
	@PostMapping("/api/")
	Ultility addUlti(@Valid @RequestBody Ultility ultility); 
}
