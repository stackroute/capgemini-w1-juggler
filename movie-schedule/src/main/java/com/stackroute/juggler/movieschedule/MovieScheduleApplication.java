package com.stackroute.juggler.movieschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient  // for eureka server to find this application
=======
//@EnableDiscoveryClient  // for eureka server to find this application
>>>>>>> 63ce83ece91d925925a048a33402f1329815819d
@SpringBootApplication
public class MovieScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieScheduleApplication.class, args);
	}
}
