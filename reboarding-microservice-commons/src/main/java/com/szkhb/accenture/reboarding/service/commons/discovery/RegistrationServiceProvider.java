package com.szkhb.accenture.reboarding.service.commons.discovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Service;

import com.szkhb.accenture.reboarding.domain.EntryRequest;
import com.szkhb.accenture.reboarding.service.commons.discovery.config.OnePathServiceDiscoveryConfig;
import com.szkhb.accenture.reboarding.service.commons.discovery.config.ServiceDiscoveryConfigs;

@Service
@EnableDiscoveryClient
public class RegistrationServiceProvider extends ServiceInterfaceTemplate {

	private OnePathServiceDiscoveryConfig registrationServiceConfig;

	@Autowired
	private void init(ServiceDiscoveryConfigs servicesConfig) {
		registrationServiceConfig = servicesConfig.getRegistrationService();
	}

	public EntryRequest getExistingOrCreateNewEntryRequest(int userId) {
		return postForObject(registrationServiceConfig.getName(), generateFullPath(userId), EntryRequest.class);
	}

	private String generateFullPath(int userId) {
		return registrationServiceConfig.getPath() + userId;
	}
}
