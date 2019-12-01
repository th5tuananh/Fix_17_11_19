package com.lhq.landservice.configuration;

import org.springframework.context.annotation.Configuration;

import com.lhq.landservice.model.Land;

@Configuration
public class LandConfig {
	public Land land() {
			return new Land();
		
	}
}
