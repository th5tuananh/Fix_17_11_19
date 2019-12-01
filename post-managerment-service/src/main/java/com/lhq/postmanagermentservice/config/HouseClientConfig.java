package com.lhq.postmanagermentservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class HouseClientConfig {
	@Bean
	Logger.Level feignLoggerLevel(){
		return Logger.Level.HEADERS;
	}
}
