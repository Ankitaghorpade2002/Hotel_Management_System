package com.guest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.guest.Exception.InvalidGuestException;
import com.guest.models.Guest;
import com.guest.repository.GuestRepository;

@Component
public class GuestDao {
	
	 @Autowired
	    private GuestRepository guestRepo;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    public List<Guest> getAllGuests() throws InvalidGuestException {
	        // Check if the authenticated user is an admin
	        if (!isAdminUser()) {
	            throw new InvalidGuestException("Access denied");
	        }

	        return guestRepo.findAll();
	    }

	    public String addGuest(Guest guest) throws InvalidGuestException {
	        String emailId = guest.getGuestEmailId();
	        Guest existingUser = guestRepo.findByGuestEmailId(emailId);
	        if (existingUser != null) {
	            throw new InvalidGuestException("Guest with email ID: " + emailId + " already exists");
	        }

	        guest.setGuestpassword(passwordEncoder.encode(guest.getGuestpassword()));
	        guestRepo.save(guest);
	        return "Guest added successfully";
	    }


	    public Guest viewByEmailId(String emailId) throws InvalidGuestException {
	        // Check if the authenticated user is an admin
	        if (!isAdminUser()) {
	            throw new InvalidGuestException("Access denied");
	        }

	        Guest guest = guestRepo.findByGuestEmailId(emailId);
	        if (guest == null) {
	            throw new InvalidGuestException("Guest not found with email ID: " + emailId);
	        }
	        return guest;
	    }

	    public Guest viewUserByEmailIdAndPassword(String emailId, String password) throws InvalidGuestException {
	    	Guest guest = guestRepo.findByGuestEmailIdAndGuestpassword(emailId, password);
	        if (guest == null) {
	            throw new InvalidGuestException("Invalid email ID or password");
	        }
	        return guest;
	    }

	    public String deleteGuest(int userId) throws InvalidGuestException {
	        // Check if the authenticated user is an admin
	        if (!isAdminUser()) {
	            throw new InvalidGuestException("Access denied");
	        }

	        Guest guest = guestRepo.findById(userId).orElse(null);
	        if (guest == null) {
	            throw new InvalidGuestException("Guest not found with ID: " + userId);
	        }
	        guestRepo.deleteById(userId);
	        return "The Guest is deleted successfully";
	    }
	    
	    
	    
	    private boolean isAdminUser() {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        return authentication != null && authentication.getAuthorities().stream()
	                .anyMatch(authority -> authority.getAuthority().equals("ADMIN"));
	    }
}
