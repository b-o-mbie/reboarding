package com.szkhb.accenture.reboarding.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Getter
@Configuration
@ConfigurationProperties(prefix = "office")
public class OfficeConfig {

	private int capacity;
	private int utilization;

}
