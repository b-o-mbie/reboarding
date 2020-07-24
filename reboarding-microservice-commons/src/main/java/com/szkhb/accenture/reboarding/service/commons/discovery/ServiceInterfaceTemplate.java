
package com.szkhb.accenture.reboarding.service.commons.discovery;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.client.RestTemplate;

public abstract class ServiceInterfaceTemplate {

	private AtomicInteger serviceRotator = new AtomicInteger(0);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient client;

	protected <T> T getForObject(String serviceId, String path, Class<T> tClass) {
		return restTemplate.getForObject(getUrl(serviceId, path), tClass);
	}

	protected <T> T postForObject(String serviceId, String path, Class<T> tClass) {
		return restTemplate.postForObject(getUrl(serviceId, path), null, tClass);
	}

	private String getUrl(String serviceId, String path) {
		String baseUrl = getUrlOfNextApplicableService(serviceId);
		return baseUrl + path;
	}

	private String getUrlOfNextApplicableService(String serviceId) {
		return getNextApplicableService(serviceId).getUri().toString();
	}

	private ServiceInstance getNextApplicableService(String serviceId) {
		List<ServiceInstance> instances = getInstancesFailFast(serviceId);
		int adaquateServiceIndex = serviceRotator.updateAndGet(v -> (v + 1) % instances.size());
		return instances.get(adaquateServiceIndex);
	}

	private List<ServiceInstance> getInstancesFailFast(String serviceId) {
		if (!client.getServices().contains(serviceId)) {
			// TODO: throw exception: NON EXISTING SERVICE
		}

		List<ServiceInstance> instances = client.getInstances(serviceId);

		if (instances.size() == 0) {
			// TODO: throw exception: THERE'S NO SUCH DEPLOYMENT
		}

		return instances;
	}

}
