package com.userservice.UserService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Userinfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int SrNo;
	private String membercode;
	private long phonenumber;
	private String company;
	private String name;
	private String email;
	private String gender;
	private String address;
	
	
	public int getSrNo() {
		return SrNo;
	}


	public void setSrNo(int srNo) {
		SrNo = srNo;
	}


	public String getMembercode() {
		return membercode;
	}


	public void setMembercode(String membercode) {
		this.membercode = membercode;
	}


	public long getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}



	


	public Userinfo(int srNo, String membercode, long phonenumber, String company, String name, String email,
			 String gender, String address) {
		super();
		SrNo = srNo;
		this.membercode = membercode;
		this.phonenumber = phonenumber;
		this.company = company;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.address = address;
	}


	public Userinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
