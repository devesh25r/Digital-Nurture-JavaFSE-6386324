package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class HandsOn1App {

	private static final Logger LOGGER = LoggerFactory.getLogger(HandsOn1App.class);

	public static void main(String[] args) {
		SpringApplication.run(HandsOn1App.class, args);
		LOGGER.info("Inside main");
	}
}

