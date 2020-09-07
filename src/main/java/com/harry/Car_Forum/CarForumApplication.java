package com.harry.Car_Forum;

import com.harry.Car_Forum.backend.persistance.PostRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.harry.Audio_Forum")
public class CarForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarForumApplication.class, args);
		PostRepository.addPost("post ze springa", "spring main");
	}

}
