package com.x.project.application.layer.business.delegate.discovery;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

/**
 * Implementation of {@link DiscoveryService} interface.
 * 
 * @author Esteban Cristóbal
 */
public class DiscoveryServiceImpl implements DiscoveryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiscoveryServiceImpl.class);

    private DiscoveryClient discoveryClient;

    /*
     * (non-Javadoc)
     * 
     * @see com.x.project.application.layer.business.delegate.discovery.
     * DiscoveryService#getEndpoint(java.lang.String)
     */
    public String getEndpoint(String serviceName) {
        LOGGER.debug("Looking for endpoint associated to service {}", serviceName);
        final List<ServiceInstance> serviceInstances = this.discoveryClient.getInstances(serviceName);
        if(serviceInstances.size() != 1) {
            Collections.shuffle(serviceInstances, new Random());
        }
        final String endpoint = serviceInstances.get(0).getUri().toString();
        LOGGER.debug("Endpoint found for service {} is {}", serviceName, endpoint);
        return endpoint;
    }

    /**
     * @param discoveryClient
     *            the discoveryClient to set
     */
    public void setDiscoveryClient(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

}
