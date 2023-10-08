package com.userservice.UserService.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.UserService.entities.Details;
import com.userservice.UserService.entities.Userinfo;
import com.userservice.UserService.service.Userservice;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired 
	Userservice service;
	
	@PostMapping("/addinfo")
	public Details addinfo(@RequestBody Details details) {
		return service.adddetails(details);	
	}
	
	@DeleteMapping("/deletedetails/{username}")
	public void deletedetails(@PathVariable String username) {
		service.deletedetails(username);	
	}
	
	@PutMapping("/updateDetails/{username}/{checkindate}/{checkoutdate}")
	public void updatedetails(@PathVariable String username,@PathVariable LocalDate checkindate,
			@PathVariable LocalDate checkoutdate) {
		service.updatedetails(username, checkindate, checkoutdate);
	}
	
	@GetMapping("/search/{username}")
	public List searchinguser(@PathVariable String username) {
		return service.searchuser(username);
		
	}
	
	@PostMapping("/addguest")
	public String addguser(@RequestBody Userinfo guestdetails) {
		 service.addinguserdetails(guestdetails);
		 return "guest added to database";
		
	}
	
	@DeleteMapping("/deleteguest/{name}")
	public void deleteuser(@PathVariable String name) {
	   service.deleteuser(name);
		
	}
	
	@GetMapping("/alluser")
	public List alluser() {
		return service.userlist();
		
	}

}
