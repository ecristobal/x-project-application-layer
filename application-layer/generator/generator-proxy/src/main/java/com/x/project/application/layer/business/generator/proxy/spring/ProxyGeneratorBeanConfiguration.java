package com.x.project.application.layer.business.generator.proxy.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.x.project.application.layer.business.generator.proxy.ProxyGeneratorService;
import com.x.project.application.layer.business.generator.proxy.ProxyGeneratorServiceImpl;

/**
 * Proxy generator bean definition class.
 * 
 * @author Esteban Cristóbal
 */
@Configuration
public class ProxyGeneratorBeanConfiguration {

    /**
     * @return {@link ProxyGeneratorService} instance
     */
    @Bean
    public ProxyGeneratorService proxyGeneratorService() {
        return new ProxyGeneratorServiceImpl();
    }

}
