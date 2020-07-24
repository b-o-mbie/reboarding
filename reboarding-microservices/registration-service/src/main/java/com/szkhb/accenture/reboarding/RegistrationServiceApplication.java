package com.szkhb.accenture.reboarding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.szkhb.accenture.reboarding.service.RegistrationService;
import com.szkhb.accenture.reboarding.service.commons.converters.ObjectToJSONConverterService;

import ch.sbb.esta.openshift.gracefullshutdown.GracefulshutdownSpringApplication;

@SpringBootApplication
@RestController
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class RegistrationServiceApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationServiceApplication.class);

  @Autowired
  ObjectToJSONConverterService converter;

  @Autowired
  RegistrationService service;

  public static void main(String[] args) {
    GracefulshutdownSpringApplication.run(RegistrationServiceApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner() {
    return args -> {
      LOGGER.info("CommandLineRunner has started by " + this.getClass().getSimpleName());
    };
  }

  @PostMapping("/registration/{userId}")
  public String getExistingOrCreateNewEntryRequest(@PathVariable("userId") int userId) {
    return converter.convert(service.getExistingOrCreateNewEntryRequest(userId));
  }

}