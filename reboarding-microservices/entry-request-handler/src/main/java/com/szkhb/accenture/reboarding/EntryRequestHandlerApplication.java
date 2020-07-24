package com.szkhb.accenture.reboarding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.szkhb.accenture.reboarding.repository.EntryRequestRepository;
import com.szkhb.accenture.reboarding.service.EntryRequestHandlerService;
import com.szkhb.accenture.reboarding.service.commons.converters.ObjectToJSONConverterService;

import ch.sbb.esta.openshift.gracefullshutdown.GracefulshutdownSpringApplication;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
@EnableAspectJAutoProxy
public class EntryRequestHandlerApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(EntryRequestHandlerApplication.class);

  @Autowired
  private ObjectToJSONConverterService converter;

  @Autowired
  private EntryRequestHandlerService service;

  public static void main(String[] args) {
    SpringApplication.run(EntryRequestHandlerApplication.class, args);
    if (false) {
      GracefulshutdownSpringApplication.run(EntryRequestHandlerApplication.class, args);
    }
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx, EntryRequestRepository rep) {
    return args -> {
      LOGGER.info("CommandLineRunner has started by " + this.getClass().getSimpleName());
      LOGGER.error(rep.getClass().getCanonicalName());
    };
  }

  @GetMapping("/entry-request/{userId}")
  public String getExistingEntryRequest(@PathVariable("userId") int userId) {
    return converter.convert(service.getExistingEntryRequest(userId));
  }

  @PostMapping("/entry-request/{userId}")
  public String createNewEntryRequest(@PathVariable("userId") int userId) {
    return converter.convert(service.getExistingOrCreateNewEntryRequest(userId));
  }

}
