package com.stackroute.juggler.promocodes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient 
@SpringBootApplication
public class PromocodesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromocodesApplication.class, args);
	}
}
