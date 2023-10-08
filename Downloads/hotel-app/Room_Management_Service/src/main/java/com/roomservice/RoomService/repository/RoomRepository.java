package com.roomservice.RoomService.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roomservice.RoomService.entities.RoomDetails;

@Repository
public interface RoomRepository extends JpaRepository<RoomDetails, String> {

	List<RoomDetails> findAllByRoomtype(String roomtype);

}
