package com.szkhb.accenture.reboarding.service.httpcommons.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "services")
public class ServicesConfig {
    private ServiceConfig apiGateway;
    private ServiceConfig registrationService;
}
