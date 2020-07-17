package com.szkhb.accenture.reboarding.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "entry-request-handler")
public class EntryRequestHandlerConfig {
	private String test;
}
