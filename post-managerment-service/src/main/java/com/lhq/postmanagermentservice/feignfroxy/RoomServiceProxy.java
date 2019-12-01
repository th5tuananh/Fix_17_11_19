package com.lhq.postmanagermentservice.feignfroxy;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lhq.postmanagermentservice.model.Room;

@FeignClient(name="room-service", url="localhost:8008")
public interface RoomServiceProxy {
		
	@GetMapping("/api/room/{id}")
	public List<Room> getRoom(@PathVariable("id") int id);
	
	
	@PostMapping("/api/room")
	Room addRoom(@Valid @RequestBody Room room); 
}
