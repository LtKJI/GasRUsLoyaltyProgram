package com.ics499.loyalty;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// // import org.springframework.boot.autoconfigure.domain.EntityScan;
// // import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// // import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableJpaRepositories(basePackages = {"com.ics499.loyalty.repositories"})
public class LoyaltyProgramApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoyaltyProgramApplication.class, args);
	}

}
