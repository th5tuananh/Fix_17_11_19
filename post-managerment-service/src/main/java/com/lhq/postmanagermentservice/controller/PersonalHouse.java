package com.lhq.postmanagermentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhq.postmanagermentservice.feignfroxy.HomeServiceProxy;
import com.lhq.postmanagermentservice.model.House;

@RestController
@RequestMapping("/personal/house")
public class PersonalHouse {

	@Autowired
	HomeServiceProxy homeProxy;
	
	
	@GetMapping("/{id}")
	public House getHouse(@PathVariable("id") Long houseId) {
		
		return homeProxy.getHouseById(houseId);
	}
}
