package com.guest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.guest.Exception.InvalidGuestException;
import com.guest.dao.GuestDao;
import com.guest.models.Guest;
import com.guest.repository.GuestRepository;

@Service
public class GuestService {
	
	@Autowired
	GuestDao dao;
	
	public List<Guest> getAllGuests() throws InvalidGuestException {
		return dao.getAllGuests();
	}
	
	public String addGuest(Guest guest) throws InvalidGuestException{
		return dao.addGuest(guest);
	}
	
	
	public Guest viewByEmailId(String emailId) throws InvalidGuestException{
		return dao.viewByEmailId(emailId);
	}
	
	public Guest ViewGuestByEmailIdAndPassword(String emailId, String password) throws InvalidGuestException {
		return dao.viewUserByEmailIdAndPassword(emailId, password);
	}
	
	public String deleteGuests(int userId) throws InvalidGuestException {
		return dao.deleteGuest(userId);	
	}

	public String getUserRole(String emailId) {
        try {
        	Guest guest = dao.viewByEmailId(emailId);
            return guest.getRole();
        } catch (InvalidGuestException e) {
            return "Unknown";
        }
    }
	

}
