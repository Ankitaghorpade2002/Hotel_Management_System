package com.staffservice.Staff_Management_Service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staffservice.Staff_Management_Service.entities.StaffDetails;
import com.staffservice.Staff_Management_Service.repository.StaffRepository;


@Service
public class StaffService {
	
	@Autowired
	StaffRepository staffrepository;
	
	public List<StaffDetails> Stafflist(){
		return staffrepository.findAll();
	}
	
	public StaffDetails Adingstaff(StaffDetails staffdetails) {
		return staffrepository.save(staffdetails);
		
	}
	
	public void deletestaffmember(String emp_name) {
		staffrepository.deleteById(emp_name);
	}
	
	public List<StaffDetails> allstaff(){
		return staffrepository.findAll();
		
	}

}
