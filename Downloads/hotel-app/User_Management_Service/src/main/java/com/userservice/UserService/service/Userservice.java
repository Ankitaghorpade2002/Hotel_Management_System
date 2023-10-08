package com.userservice.UserService.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.UserService.entities.Details;
import com.userservice.UserService.entities.Userinfo;
import com.userservice.UserService.repository.DetailsRepository;
import com.userservice.UserService.repository.UserRepository;


@Service
public class Userservice {
	
	@Autowired
	DetailsRepository detailsrepository;
	
	@Autowired
	UserRepository userrepository;
	
	public Details adddetails(Details details) {
		return detailsrepository.save(details);
	}
	public void deletedetails(String username) {
		detailsrepository.deleteById(username);
	}
	
	public void updatedetails(String username ,LocalDate checkindate,LocalDate checkoutdate) {
		Details details=detailsrepository.findById(username).orElse(null);
		details.setCheckindate(checkindate);
		details.setCheckoutdate(checkoutdate);
		detailsrepository.save(details);
		}
	
	public List<Details> searchuser(String username) {
		return detailsrepository.findAllByUsername(username);
	}

	public Userinfo addinguserdetails(Userinfo details) {
		return userrepository.save(details);
		
	}
	
	public void deleteuser(String name) {
		userrepository.deleteById(name);
	}
	
	public List<Details> userlist(){
		return detailsrepository.findAll();
		
	}
	

}
