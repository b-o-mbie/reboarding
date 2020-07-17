package com.szkhb.accenture.reboarding.config.discovery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDiscoveryConfig implements DiscoverableByName {
	private String name;
}
