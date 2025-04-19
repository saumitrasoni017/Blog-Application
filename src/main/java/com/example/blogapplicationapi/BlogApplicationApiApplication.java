package com.example.blogapplicationapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlogApplicationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplicationApiApplication.class, args);
	}

}
