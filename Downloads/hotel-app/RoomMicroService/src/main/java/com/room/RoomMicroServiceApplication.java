package com.room;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class RoomMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomMicroServiceApplication.class, args);
	}

}
