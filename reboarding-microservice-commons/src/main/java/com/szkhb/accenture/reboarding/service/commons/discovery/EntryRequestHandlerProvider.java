package com.szkhb.accenture.reboarding.service.commons.discovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Service;

import com.szkhb.accenture.reboarding.domain.EntryRequest;
import com.szkhb.accenture.reboarding.service.commons.discovery.config.OnePathServiceDiscoveryConfig;
import com.szkhb.accenture.reboarding.service.commons.discovery.config.ServiceDiscoveryConfigs;

@Service
@EnableDiscoveryClient
public class EntryRequestHandlerProvider extends ServiceInterfaceTemplate {

  private OnePathServiceDiscoveryConfig erhServiceConfig;

  @Autowired
  private void init(ServiceDiscoveryConfigs servicesConfig) {
    erhServiceConfig = servicesConfig.getEntryRequestHandler();
  }

  public EntryRequest getExistingEntryRequest(int userId) {
    return getForObject(erhServiceConfig.getName(), generateFullPath(userId), EntryRequest.class);
  }

  public EntryRequest getExistingOrCreateNewEntryRequest(int userId) {
    return postForObject(erhServiceConfig.getName(), generateFullPath(userId), EntryRequest.class);
  }

  private String generateFullPath(int userId) {
    return erhServiceConfig.getPath() + userId;
  }

}
