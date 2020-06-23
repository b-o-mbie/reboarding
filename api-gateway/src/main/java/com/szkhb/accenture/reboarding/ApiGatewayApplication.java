package com.szkhb.accenture;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableConfigurationProperties
public class EntryRequestHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntryRequestHandlerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("CommandLineRunner has started by " + this.getClass().getSimpleName());
		};
	}

	@RequestMapping("/api")
	public String api() {
		return "Hello Docker World, this is " + this.getClass().getName();
	}

}
