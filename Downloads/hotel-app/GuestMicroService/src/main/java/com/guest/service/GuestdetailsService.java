package com.guest.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guest.config.GuestInfoDetails;
import com.guest.models.Guest;
import com.guest.repository.GuestRepository;

@Component
public class GuestdetailsService implements UserDetailsService{
	
	@Autowired
	private GuestRepository repository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String guestEmailId) throws UsernameNotFoundException {
	    Guest guest = repository.findByGuestEmailId(guestEmailId);
	    if (guest == null) {
	        throw new UsernameNotFoundException("Guest NOT Found : " + guestEmailId);
	    }
	    return new GuestInfoDetails(guest);
	}

}
