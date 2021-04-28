package com.ics499.loyalty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.cors.*;
import java.util.*;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class LoyaltyProgramApplication {

	@Bean
	public CorsFilter corsFilter() {
		
		UrlBasedCorsConfigurationSource urlBasedCorsConifgSource = new UrlBasedCorsConfigurationSource();
		
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowCredentials(true);
		corsConfig.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
		corsConfig.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfig.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		
		urlBasedCorsConifgSource.registerCorsConfiguration("/**", corsConfig);
		
		return new CorsFilter(urlBasedCorsConifgSource);
		
	}

	public static void main(String[] args) {
		SpringApplication.run(LoyaltyProgramApplication.class, args);
	}

}
