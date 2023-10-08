package com.room.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.room.repository.RoomRepository;
import com.room.models.Room;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;

	public void addRoom(Room room) {
		roomRepository.insert(room);
	}

	public List<Room> getAllRooms() {
		List<Room> list1 = new ArrayList<>();
		list1=roomRepository.findAll();
		return list1;
	}

	public void updateRoom(Room room, int roomId) {
		roomRepository.save(room);
	}

	public void deleteRoom(int roomId) {
		roomRepository.deleteById(roomId);
	}

	public Optional<Room> getRoomById(int roomId) {
		return roomRepository.findById(roomId);
	}
	
	public List<Room> getRoomByRoomtype(String roomType) {
		return roomRepository.findAllByRoomType(roomType);
	}
}
