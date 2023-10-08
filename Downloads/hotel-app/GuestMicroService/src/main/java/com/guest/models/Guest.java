package com.guest.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
@Document(collection = "Guests")
public class Guest {
	
	
	@Id
    private int guestId;
	
	private String guestName;
	
	private int guestAge;
	
	@Pattern(regexp = "\\d{10}")
	private long guestContactNo;
	
	@Pattern(regexp = "^[a-z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-z0-9.-]+$")
	@NotBlank(message = "Email cannot be empty")
	private String guestEmailId;
	
	private String guestAddress;
	
	private String guestpassword;
	
	private String role;

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public int getGuestAge() {
		return guestAge;
	}

	public void setGuestAge(int guestAge) {
		this.guestAge = guestAge;
	}

	public long getGuestContactNo() {
		return guestContactNo;
	}

	public void setGuestContactNo(long guestContactNo) {
		this.guestContactNo = guestContactNo;
	}

	public String getGuestEmailId() {
		return guestEmailId;
	}

	public void setGuestEmailId(String guestEmailId) {
		this.guestEmailId = guestEmailId;
	}

	public String getGuestAddress() {
		return guestAddress;
	}

	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}

	public String getGuestpassword() {
		return guestpassword;
	}

	public void setGuestpassword(String guestpassword) {
		this.guestpassword = guestpassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Guest(int guestId, String guestName, int guestAge, @Pattern(regexp = "\\d{10}") long guestContactNo,
			@Pattern(regexp = "^[a-z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-z0-9.-]+$") @NotBlank(message = "Email cannot be empty") String guestEmailId,
			String guestAddress, String guestpassword, @Pattern(regexp = "CUSTOMER|DEALER|ADMIN") String role) {
		super();
		this.guestId = guestId;
		this.guestName = guestName;
		this.guestAge = guestAge;
		this.guestContactNo = guestContactNo;
		this.guestEmailId = guestEmailId;
		this.guestAddress = guestAddress;
		this.guestpassword = guestpassword;
		this.role = role;
	}

	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";
	
	

}
