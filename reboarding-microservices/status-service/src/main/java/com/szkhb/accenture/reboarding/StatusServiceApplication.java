package com.szkhb.accenture.reboarding;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.sbb.esta.openshift.gracefullshutdown.GracefulshutdownSpringApplication;

@SpringBootApplication
@RestController
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class StatusServiceApplication {

	public static void main(String[] args) {
		GracefulshutdownSpringApplication.run(StatusServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("CommandLineRunner has started by " + this.getClass().getSimpleName());

		};
	}

	@RequestMapping("/status")
	public String status() {
		return "Hello Docker World, this is " + this.getClass().getName();
	}
}