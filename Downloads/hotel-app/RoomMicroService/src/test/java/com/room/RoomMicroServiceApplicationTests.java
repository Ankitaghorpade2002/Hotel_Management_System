package com.room;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.room.controller.RoomController;
import com.room.models.Room;
import com.room.service.RoomService;
import com.room.service.SequenceGeneratorservice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class RoomMicroServiceApplicationTests {

	
	@Mock
    private RoomService roomService;

    @Mock
    private SequenceGeneratorservice sequenceGeneratorservice;

    @InjectMocks
    private RoomController roomController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
	@Test
	void contextLoads() {
	}
	
	@Test
    void addRoom_ValidRoom_ReturnsCreatedStatus() {
        Room room = new Room();
        room.setRoomId(1);
        when(sequenceGeneratorservice.getSequenceNumber(anyString())).thenReturn(1);
        doNothing().when(roomService).addRoom(room);

        ResponseEntity<Void> response = roomController.addRoom(room);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(sequenceGeneratorservice, times(1)).getSequenceNumber(anyString());
        verify(roomService, times(1)).addRoom(room);
    }
	
	@Test
    void updateRoom_ValidRoomAndId_ReturnsAcceptedStatus() {
        Room room = new Room();
        int roomId = 1;
        doNothing().when(roomService).updateRoom(room,roomId);

        ResponseEntity<Void> response = roomController.updateRoom(room, roomId);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        verify(roomService, times(1)).updateRoom(room,roomId);
    }
	
	@Test
    void deleteRoom_ValidId_ReturnsNoContentStatus() {
        int roomId = 1;
        doNothing().when(roomService).deleteRoom(roomId);

        ResponseEntity<Void> response = roomController.deleteRoom(roomId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(roomService, times(1)).deleteRoom(roomId);
    }
	
	@Test
    void getAllRooms_RoomsExist_ReturnsListOfRooms() {
        Room room1 = new Room();
        room1.setRoomId(1);
        Room room2 = new Room();
        room2.setRoomId(2);
        List<Room> roomList = Arrays.asList(room1, room2);
        when(roomService.getAllRooms()).thenReturn(roomList);

        ResponseEntity<List<Room>> response = roomController.getAllRooms();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(roomList, response.getBody());
        verify(roomService, times(1)).getAllRooms();
    }
	
//	@Test
//    void getAllRooms_NoRoomsExist_ReturnsNotFoundStatus() {
//        when(roomService.getAllRooms()).thenReturn(Arrays.asList());
//
//        ResponseEntity<List<Room>> response = roomController.getAllRooms();
//
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        assertEquals(0, response.getBody().size());
//        verify(roomService, times(1)).getAllRooms();
//    }
	
	@Test
    void getRoomById_ValidId_ReturnsRoom() {
        int roomId = 1;
        Room room = new Room();
        room.setRoomId(roomId);
        Optional<Room> roomOptional = Optional.of(room);
        when(roomService.getRoomById(roomId)).thenReturn(roomOptional);

        ResponseEntity<Optional<Room>> response = roomController.getRoomById(roomId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(roomOptional, response.getBody());
        verify(roomService, times(1)).getRoomById(roomId);
    }

}
