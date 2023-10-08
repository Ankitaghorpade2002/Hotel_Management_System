package com.staffservice.Staff_Management_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StaffManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffManagementServiceApplication.class, args);
	}

}
