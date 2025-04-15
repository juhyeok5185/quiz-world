package com.danny.quizworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ThinkDockApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThinkDockApplication.class, args);
	}

}
