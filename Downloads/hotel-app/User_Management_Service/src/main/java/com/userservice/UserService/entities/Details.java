package com.userservice.UserService.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Details {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SrNo")
	private int SrNo;
	private String username;
	private String code;
	private int numberofchildern;
	private int numberofadults;
	private LocalDate checkindate;
	private LocalDate checkoutdate;
	private String status;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getNumberofchildern() {
		return numberofchildern;
	}
	public void setNumberofchildern(int numberofchildern) {
		this.numberofchildern = numberofchildern;
	}
	public int getNumberofadults() {
		return numberofadults;
	}
	public void setNumberofadults(int numberofadults) {
		this.numberofadults = numberofadults;
	}
	
	public LocalDate getCheckindate() {
		return checkindate;
	}
	public void setCheckindate(LocalDate checkindate) {
		this.checkindate = checkindate;
	}
	public LocalDate getCheckoutdate() {
		return checkoutdate;
	}
	public void setCheckoutdate(LocalDate checkoutdate) {
		this.checkoutdate = checkoutdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Details(String username, String code, int numberofchildern, int numberofadults,
			LocalDate checkindate, LocalDate checkoutdate, String status) {
		super();
		
		this.username = username;
		this.code = code;
		this.numberofchildern = numberofchildern;
		this.numberofadults = numberofadults;
		this.checkindate = checkindate;
		this.checkoutdate = checkoutdate;
		this.status = status;
	}
	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
