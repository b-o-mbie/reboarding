package com.szkhb.accenture.reboarding.service.commons.discovery.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "services")
public class ServiceDiscoveryConfigs {

	private ServiceDiscoveryConfig apiGateway;

	private OnePathServiceDiscoveryConfig registrationService;
	private OnePathServiceDiscoveryConfig statusService;
	private OnePathServiceDiscoveryConfig entryService;
	private OnePathServiceDiscoveryConfig exitService;
	private OnePathServiceDiscoveryConfig entryRequestHandler;
}
