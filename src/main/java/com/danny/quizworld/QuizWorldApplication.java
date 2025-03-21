package com.danny.quizworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class QuizWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizWorldApplication.class, args);
	}

}
