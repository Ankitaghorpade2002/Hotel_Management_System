package com.roomservice.RoomService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roomservice.RoomService.entities.RoomDetails;
import com.roomservice.RoomService.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

	@Autowired
	RoomService roomservice; 
	
	@GetMapping("/rooms/{roomtype}")
	public List searchingrooms(@PathVariable String roomtype) {
		return roomservice.searchroom(roomtype);
	}
	
	@PostMapping("/addingroom")
	public RoomDetails addingroom(@RequestBody RoomDetails roomdetails) {
		return roomservice.Addingroominfo(roomdetails);
	}
	@DeleteMapping("/deleteroom/{roomno}")
	public void deleteroom(@PathVariable String roomno) {
		roomservice.deleterooms(roomno);
		
	}
	@GetMapping("/availablerooms")
	public List Allavailablerooms() {
	return roomservice.availablerooms();
	}
	
	@PutMapping("/update/{roomno}/{roomtype}/{price}")
	public void updateroom(@PathVariable String roomno ,@PathVariable String roomtype,@PathVariable int price) {
		roomservice.updaterooms(roomno, roomtype, price);
	}
}
