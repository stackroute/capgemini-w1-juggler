package com.stackroute.juggler.theatreregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TheatreRegistrationApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(TheatreRegistrationApplication.class, args);
	}
}
