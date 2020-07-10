package com.szkhb.accenture.reboarding.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "registration-service")
public class RegistrationServiceConfig {
    private String test;
}
