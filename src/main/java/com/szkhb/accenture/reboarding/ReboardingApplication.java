package com.szkhb.accenture.reboarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class ReboardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReboardingApplication.class, args);
	}

}
