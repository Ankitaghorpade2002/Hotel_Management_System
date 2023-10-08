package com.room.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.room.models.Room;

@Repository
public interface RoomRepository extends MongoRepository<Room, Integer>{

//	Optional<Room> findAll(String roomType);
	
	List<Room> findAllByRoomType(String roomType);
	
	

}
