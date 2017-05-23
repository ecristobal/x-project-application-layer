package com.x.project.application.layer.business.delegate.spring;

import org.mockito.Mockito;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessDelegateTestConfiguration {

    @Bean
    public DiscoveryClient discoveryClient() {
        return Mockito.mock(DiscoveryClient.class);
    }

}
