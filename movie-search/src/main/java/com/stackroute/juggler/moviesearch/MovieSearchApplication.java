package com.stackroute.juggler.moviesearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MovieSearchApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(MovieSearchApplication.class, args);
	}
}
