package com.szkhb.accenture.reboarding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.szkhb.accenture.reboarding.config.OfficeConfig;
import com.szkhb.accenture.reboarding.domain.EntryRequest;
import com.szkhb.accenture.reboarding.domain.User;
import com.szkhb.accenture.reboarding.service.httpcommons.converters.EntryRequestToJSONConverterService;

import ch.sbb.esta.openshift.gracefullshutdown.GracefulshutdownSpringApplication;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class EntryRequestHandlerApplication {

	@Autowired
	EntryRequestToJSONConverterService converter;

	public static void main(String[] args) {
		GracefulshutdownSpringApplication.run(EntryRequestHandlerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
		};
	}

	@GetMapping("/entry-request/{userId}")
	public String getExistingEntryRequest(@PathVariable("userId") int userId) {
		return converter.entryRequestToJSON(getEntry(userId));
	}

	@PostMapping("/entry-request/{userId}")
	public String createNewEntryRequest(@PathVariable("userId") int userId) {
		return converter.entryRequestToJSON(getEntry(userId));
	}

	private EntryRequest getEntry(int userId) {
		EntryRequest entryRequest = new EntryRequest();
		User user = new User();
		user.setId(userId);
		entryRequest.setUser(user);
		return entryRequest;
	}

}
