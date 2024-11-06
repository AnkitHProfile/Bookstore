package org.project.Bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // This tells Spring Boot that this is the main configuration class for my app
public class BookstoreApplication { // This is the main class where my application starts

	public static void main(String[] args) {
		// main method is the entry point of the application
		SpringApplication.run(BookstoreApplication.class, args);
		// This line starts the Spring Boot application by calling run() and passing my main class and args
	}
}