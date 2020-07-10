package com.szkhb.accenture.reboarding.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "api-gateway")
public class ApiGatewayConfig {
	private String test;
}
