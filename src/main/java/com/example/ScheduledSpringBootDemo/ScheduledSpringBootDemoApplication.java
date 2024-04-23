package com.example.ScheduledSpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Our Spring Boot application Main class;
 */

@SpringBootApplication
@EnableScheduling
public class ScheduledSpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduledSpringBootDemoApplication.class, args);
	}

}