package com.lhq.postmanagermentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients("com.lhq.postmanagermentservice")
@SpringBootApplication
public class PostManagermentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostManagermentServiceApplication.class, args);
	}

}
