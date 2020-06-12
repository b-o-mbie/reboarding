package com.szkhb.accenture.reboarding;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.szkhb.accenture.reboarding.config.OfficeConfig;

@SpringBootApplication
@EnableConfigurationProperties
public class ReboardingApplication {

	@Autowired
	private OfficeConfig officeConfig;

	public static void main(String[] args) {
		SpringApplication.run(ReboardingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("CommandLineRunner has started.");
			System.out.println(officeConfig);

		};
	}

}
