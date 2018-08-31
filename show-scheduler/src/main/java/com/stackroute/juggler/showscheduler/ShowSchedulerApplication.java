package com.stackroute.juggler.showscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ShowSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowSchedulerApplication.class, args);
	}
}
