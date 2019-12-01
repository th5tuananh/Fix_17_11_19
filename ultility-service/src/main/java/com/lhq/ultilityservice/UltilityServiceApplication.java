package com.lhq.ultilityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UltilityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UltilityServiceApplication.class, args);
	}

}
