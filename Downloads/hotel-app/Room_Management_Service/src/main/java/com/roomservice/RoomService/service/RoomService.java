package com.roomservice.RoomService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roomservice.RoomService.entities.RoomDetails;
import com.roomservice.RoomService.repository.RoomRepository;


@Service
public class RoomService {
	
	@Autowired
	RoomRepository roomrepository;
	
	public List<RoomDetails> searchroom(String roomtype) {
		return roomrepository.findAllByRoomtype(roomtype);
	}
	
	public RoomDetails Addingroominfo(RoomDetails roomdetails) {
		return roomrepository.save(roomdetails);
	}
	
	public void deleterooms(String roomno) {
		roomrepository.deleteById(roomno);
	}
	public List<RoomDetails> availablerooms(){
		return roomrepository.findAll();
	}
	
	public void updaterooms(String roomno ,String roomtype,int price) {
		RoomDetails roomdetails=roomrepository.findById(roomno).orElse(null);
		roomdetails.setRoomtype(roomtype);
		roomdetails.setPrice(price);
		roomrepository.save(roomdetails);
		}

}
