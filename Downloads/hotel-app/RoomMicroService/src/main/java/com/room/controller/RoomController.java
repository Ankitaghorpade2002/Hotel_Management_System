package com.room.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.room.models.Room;
import com.room.service.RoomService;
import com.room.service.SequenceGeneratorservice;


@RequestMapping("/room")
@RestController
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@Autowired
	private SequenceGeneratorservice sequenceGeneratorservice;

	@PostMapping("/add")
	public ResponseEntity<Void> addRoom(@RequestBody Room room) {
		try {
			room.setRoomId(sequenceGeneratorservice.getSequenceNumber(room.SEQUENCE_NAME));
			roomService.addRoom(room);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/update/{roomId}")
	public ResponseEntity<Void> updateRoom(@RequestBody Room room, @PathVariable(value = "roomId") int roomId) {
		try {
			roomService.updateRoom(room,roomId);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/delete/{roomId}")
	public ResponseEntity<Void> deleteRoom( @PathVariable(value = "roomId") int roomId) {
		try {
			roomService.deleteRoom(roomId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Room>> getAllRooms(){
		List<Room> list = roomService.getAllRooms();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/getbyroomid/{roomId}")
	public ResponseEntity<Optional<Room>> getRoomById(@PathVariable(value = "roomId") int roomId){
		
		try {
			Optional<Room> room = roomService.getRoomById(roomId);
			if(room==null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			else {
				return ResponseEntity.of(Optional.of(room));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/getroombyroomtype/{roomType}")
	public ResponseEntity<List<Room>> getRoomByRoomtype(@PathVariable(value = "roomType") String roomType){
		
		try {
			List<Room> room = roomService.getRoomByRoomtype(roomType);
			if(room==null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			else {
				return ResponseEntity.of(Optional.of(room));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
