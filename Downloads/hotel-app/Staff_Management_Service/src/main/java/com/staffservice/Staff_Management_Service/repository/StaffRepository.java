package com.staffservice.Staff_Management_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.staffservice.Staff_Management_Service.entities.StaffDetails;

@Repository
public interface StaffRepository extends JpaRepository<StaffDetails, String>{

}
