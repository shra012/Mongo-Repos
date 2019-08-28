package com.spring.applicatiom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages="com.spring")
@EnableMongoRepositories(basePackages="com.spring")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
