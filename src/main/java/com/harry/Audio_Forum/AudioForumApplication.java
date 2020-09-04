package com.harry.Audio_Forum;

import com.harry.Audio_Forum.backend.repositories.PostRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.harry.Audio_Forum")
public class AudioForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(AudioForumApplication.class, args);
		PostRepository.addPost("post ze springa", "spring main");
	}

}
