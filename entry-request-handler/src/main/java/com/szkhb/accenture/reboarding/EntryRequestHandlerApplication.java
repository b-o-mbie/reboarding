package com.szkhb.accenture.reboarding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.szkhb.accenture.reboarding.config.OfficeConfig;
import com.szkhb.accenture.reboarding.domain.EntryRequest;
import com.szkhb.accenture.reboarding.repository.EntryRequestRepository;

@SpringBootApplication
@RestController
@EnableConfigurationProperties
public class EntryRequestHandlerApplication {

	@Autowired
	private OfficeConfig officeConfig;

	@Autowired
	private EntryRequestRepository entryRepÏo;

	public static void main(String[] args) {
		SpringApplication.run(EntryRequestHandlerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("CommandLineRunner has started.");
			System.out.println(officeConfig);

			System.out.println(new EntryRequest());
			System.out.println(new EntryRequest());

		};
	}

	@RequestMapping("/heartbeat")
	public String heartbeat() {
		return "Hello Docker World, this is " + this.getClass().getName();
	}

}
