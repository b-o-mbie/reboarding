package com.szkhb.accenture.reboarding.config.discovery;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OnePathServiceDiscoveryConfig extends ServiceDiscoveryConfig {
	private String path;
}
