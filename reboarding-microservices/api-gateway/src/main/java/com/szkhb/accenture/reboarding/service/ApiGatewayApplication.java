package com.szkhb.accenture.reboarding.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.szkhb.accenture.reboarding.domain.EntryRequest;
import com.szkhb.accenture.reboarding.service.commons.converters.ObjectToJSONConverterService;
import com.szkhb.accenture.reboarding.service.commons.discovery.RegistrationServiceProvider;

import ch.sbb.esta.openshift.gracefullshutdown.GracefulshutdownSpringApplication;

@SpringBootApplication
@RestController
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class ApiGatewayApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(ApiGatewayApplication.class);

  @Autowired
  private RegistrationServiceProvider registrationService;

  @Autowired
  private ObjectToJSONConverterService converter;

  public static void main(String[] args) {
    GracefulshutdownSpringApplication.run(ApiGatewayApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      LOGGER.info("CommandLineRunner has started by " + this.getClass().getSimpleName());
    };
  }

  @GetMapping("/registration/{userId}")
  public String getEntry(@PathVariable("userId") int userId) {
    return getOrCreateEntry(userId);
  }

  @PostMapping("/registration/{userId}")
  public String getOrCreateEntry(@PathVariable("userId") int userId) {
    EntryRequest entryRequest = registrationService.getExistingOrCreateNewEntryRequest(userId);
    return converter.convert(entryRequest);
  }

}
