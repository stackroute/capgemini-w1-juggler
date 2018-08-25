package com.stackroute.juggler.movieschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient // for eureka server to find this application
@SpringBootApplication
public class MovieScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieScheduleApplication.class, args);
	}
}
