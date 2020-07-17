package com.szkhb.accenture.reboarding.service.httpcommons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Service;

import com.szkhb.accenture.reboarding.config.discovery.OnePathServiceDiscoveryConfig;
import com.szkhb.accenture.reboarding.config.discovery.ServiceDiscoveryConfigs;
import com.szkhb.accenture.reboarding.domain.EntryRequest;

@Service
@EnableDiscoveryClient
public class EntryRequestHandlerProvider extends ServiceInterfaceTemplate {

	private OnePathServiceDiscoveryConfig erhServiceConfig;

	@Autowired
	private void init(ServiceDiscoveryConfigs servicesConfig) {
		erhServiceConfig = servicesConfig.getEntryRequestHandler();
		System.out.println(erhServiceConfig);
	}

	public EntryRequest getExistingEntryRequest(int userId) {
		return getForObject(erhServiceConfig.getName(), generateFullPath(userId), EntryRequest.class);
	}

	public EntryRequest createNewEntryRequest(int userId) {
		return postForObject(erhServiceConfig.getName(), generateFullPath(userId), EntryRequest.class);
	}

	private String generateFullPath(int userId) {
		return erhServiceConfig.getPath() + userId;
	}

}
