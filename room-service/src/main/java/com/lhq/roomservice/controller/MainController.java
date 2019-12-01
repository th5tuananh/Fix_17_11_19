package com.lhq.roomservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhq.roomservice.model.Room;
import com.lhq.roomservice.repository.RoomRepository;


@RestController
@RequestMapping("/api")
public class MainController {

	@Autowired
	private RoomRepository roomRepo;
	
	
	@GetMapping("/room/{id}")
	public List<Room> getRoomByHouseId(@PathVariable("id") int houseId){		
		return roomRepo.findByHouseId(houseId);
	}
	
	@PostMapping("/room")
	public Room createRoom(@RequestBody Room room) {
		return roomRepo.save(room);
	}
}
