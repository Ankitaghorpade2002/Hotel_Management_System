package com.roomservice.RoomService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RoomDetails {
	
	@Id
	private String roomno;
	private String roomtype;
	private int price;
	
	
	public String getRoomno() {
		return roomno;
	}


	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}


	public String getRoomtype() {
		return roomtype;
	}


	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public RoomDetails(String roomno, String roomtype, int price) {
		super();
		this.roomno = roomno;
		this.roomtype = roomtype;
		this.price = price;
	}


	public RoomDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
