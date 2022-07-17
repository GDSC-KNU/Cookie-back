package com.gdsc.cookieparking.cookieparking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CookieparkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CookieparkingApplication.class, args);
	}

}
