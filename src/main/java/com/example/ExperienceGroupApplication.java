package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExperienceGroupApplication {

	static final String SUCCESS = "SUCCESS";
	static final String NO_VALUE_ERROR = "NO VALUE";
	
	public static void main(String[] args) {
		SpringApplication.run(ExperienceGroupApplication.class, args);
	}

}
