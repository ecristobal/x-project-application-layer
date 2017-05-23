package com.x.project.application.layer.business.delegate.spring;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.x.project.application.layer.business.delegate.discovery.DiscoveryService;
import com.x.project.application.layer.business.delegate.discovery.DiscoveryServiceImpl;

/**
 * Business delegate bean definition file.
 * 
 * @author Esteban Cristóbal
 */
@Configuration
public class BusinessDelegateBeanConfiguration {

    /**
     * @param discoveryClient
     *            Eureka {@link DiscoveryClient} instance
     * @return {@link DiscoveryService} instance
     */
    @Bean
    public DiscoveryService discoveryService(final DiscoveryClient discoveryClient) {
        final DiscoveryServiceImpl discoveryService = new DiscoveryServiceImpl();
        discoveryService.setDiscoveryClient(discoveryClient);
        return discoveryService;
    }

}
