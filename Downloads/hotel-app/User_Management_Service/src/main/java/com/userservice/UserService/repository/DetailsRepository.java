package com.userservice.UserService.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userservice.UserService.entities.Details;

@Repository
public interface DetailsRepository extends JpaRepository<Details, String>{

	List<Details> findAllByUsername(String username);
}
