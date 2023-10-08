package com.booking.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bookings")
public class Booking {
	
	

	@Id
	private int bookingId;
	
//	private int roomId;
//	
//	private int guestId;
	
	private Date checkInDate;
	
	private Date checkOutDate;
	
	private int numberofadults;
	
	private int numberofchild;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

//	public int getRoomId() {
//		return roomId;
//	}
//
//	public void setRoomId(int roomId) {
//		this.roomId = roomId;
//	}
//
//	public int getGuestId() {
//		return guestId;
//	}
//
//	public void setGuestId(int guestId) {
//		this.guestId = guestId;
//	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getNumberofadults() {
		return numberofadults;
	}

	public void setNumberofadults(int numberofadults) {
		this.numberofadults = numberofadults;
	}

	public int getNumberofchild() {
		return numberofchild;
	}

	public void setNumberofchild(int numberofchild) {
		this.numberofchild = numberofchild;
	}

	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";
	
	
	
}