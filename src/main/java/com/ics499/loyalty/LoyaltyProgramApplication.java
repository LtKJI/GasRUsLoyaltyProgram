package com.ics499.loyalty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan (basePackages = ("com.ics499.loyalty.model"))
public class LoyaltyProgramApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoyaltyProgramApplication.class, args);
	}

}
