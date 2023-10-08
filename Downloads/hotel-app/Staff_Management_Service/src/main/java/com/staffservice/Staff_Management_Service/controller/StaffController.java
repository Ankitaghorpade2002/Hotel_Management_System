package com.staffservice.Staff_Management_Service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.staffservice.Staff_Management_Service.entities.StaffDetails;
import com.staffservice.Staff_Management_Service.service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired
	StaffService staffservice;
	
	@PostMapping("/addstaff")
	public String addingstaff( @RequestBody  StaffDetails staffdetails) {
		staffservice.Adingstaff(staffdetails);
		return "Staff member added to database";
		
	}
	
	@DeleteMapping("/deletestaff/{emp_name}")
	public String deletingstaffmemberbyid(@PathVariable String emp_name) {
		staffservice.deletestaffmember(emp_name);
		return emp_name+" is removed from staff member";
	}
	
	@GetMapping("/allstaffmembers")
	public List allstaff() {
		return staffservice.allstaff();
	}

}
