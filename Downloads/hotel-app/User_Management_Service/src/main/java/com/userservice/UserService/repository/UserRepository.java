package com.userservice.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.userservice.UserService.entities.Userinfo;


@Repository
public interface UserRepository extends JpaRepository<Userinfo, String>{

	
}
