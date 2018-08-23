package com.stackroute.juggler.searchmovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
//@EnableDiscoveryClient  //declaring this micro service as a client
@SpringBootApplication
public class SearchMovieApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SearchMovieApplication.class, args);
	}
}
