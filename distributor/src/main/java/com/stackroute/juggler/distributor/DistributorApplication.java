package com.stackroute.juggler.distributor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DistributorApplication {
	// This is the main entry point of the application
	public static void main(String[] args) {
		SpringApplication.run(DistributorApplication.class, args);
	}
}
