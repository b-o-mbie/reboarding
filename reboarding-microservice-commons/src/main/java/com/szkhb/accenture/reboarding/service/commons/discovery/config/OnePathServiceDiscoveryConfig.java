package com.szkhb.accenture.reboarding.service.commons.discovery.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OnePathServiceDiscoveryConfig extends ServiceDiscoveryConfig {
	private String path;
}
