package com.lhq.houseservice.configuration;

import org.springframework.context.annotation.Configuration;

import com.lhq.houseservice.model.House;

@Configuration
public class HouseConfig {
	public House house() {
		return new House();
	
}
}
