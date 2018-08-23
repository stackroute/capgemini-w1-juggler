package com.stackroute.juggler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

//@EnableDiscoveryClient declaring this micro service as a client
@SpringBootApplication
public class SearchMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchMovieApplication.class, args);
	}
}
