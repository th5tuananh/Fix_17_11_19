package com.lhq.postmanagermentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhq.postmanagermentservice.feignfroxy.RoomServiceProxy;

import com.lhq.postmanagermentservice.model.Room;
@RestController
@RequestMapping("/room")
public class RoomManager {

	@Autowired RoomServiceProxy roomProxy;
	
	@GetMapping("/{id}")
	public List<Room> getRoom(@PathVariable("id") int id){
		return roomProxy.getRoom(id);
	}
	
	@PostMapping("/")
	public Room addRoom(@RequestBody Room room) {
		return roomProxy.addRoom(room);
	}
}
