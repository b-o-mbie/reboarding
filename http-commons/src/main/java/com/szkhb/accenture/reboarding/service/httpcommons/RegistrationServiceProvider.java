package com.szkhb.accenture.reboarding.service.httpcommons;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.szkhb.accenture.reboarding.domain.EntryRequest;

@Service
@EnableDiscoveryClient
public class RegistrationServiceProvider {

    private AtomicInteger serviceRotator = new AtomicInteger(0);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient client;

    public EntryRequest getEntryRequest(int userId) {
        return restTemplate.getForObject(getUrl(userId), EntryRequest.class);
    }

    public EntryRequest getExistingOrCreateNewEntryRequest(int userId) {
        return restTemplate.postForObject(getUrl(userId), null,
                EntryRequest.class);
    }

    private String getUrl(int userId) {
        String url = getAdaquateService("registration-service")
                .getUri() + "/registration/" + userId;
        return url;
    }

    private ServiceInstance getAdaquateService(String serviceId) {
        List<ServiceInstance> instances = client.getInstances(serviceId);
        int adaquateServiceIndex = serviceRotator.updateAndGet(v -> (v + 1) % instances.size());
        System.out.println("service count: " + instances.size()
                + " current: " + adaquateServiceIndex
                + " rotator: " + serviceRotator.get());
        return instances.get(adaquateServiceIndex);
    }
}
