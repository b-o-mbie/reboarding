package com.szkhb.accenture.reboarding.service;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.szkhb.accenture.reboarding.domain.EntryRequest;
import com.szkhb.accenture.reboarding.service.config.ApiGatewayConfig;
import com.szkhb.accenture.reboarding.service.httpcommons.RegistrationServiceProvider;

import ch.sbb.esta.openshift.gracefullshutdown.GracefulshutdownSpringApplication;

@SpringBootApplication
@RestController
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class ApiGatewayApplication {

    @Autowired
    private RegistrationServiceProvider registrationService;

    @Autowired
    private ApiGatewayConfig config;

    public static void main(String[] args) {
        GracefulshutdownSpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("CommandLineRunner has started by " + this.getClass()
                    .getSimpleName());
        };
    }

    @RequestMapping("/config")
    public String api() {
        return config.toString();
    }

    private int c = 0;

    @GetMapping("/registration/{userId}")
    public String getEntry(@PathVariable("userId") int userId) {
        System.out.println("GET: registration/" + userId + " :: " + ++c);
        EntryRequest entry = registrationService
                .getEntryRequest(userId);
        return entry.toString();
    }

    @PostMapping("/registration/{userId}")
    public String getOrCreateEntry(@PathVariable("userId") int userId) {
        System.out.println("POST: registration/" + userId);
        return registrationService
                .getExistingOrCreateNewEntryRequest(userId)
                .toString();
    }

}
