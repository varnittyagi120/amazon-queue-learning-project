package com.example.amazon_queue_learning_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AmazonQueueLearningProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonQueueLearningProjectApplication.class, args);
	}

}
