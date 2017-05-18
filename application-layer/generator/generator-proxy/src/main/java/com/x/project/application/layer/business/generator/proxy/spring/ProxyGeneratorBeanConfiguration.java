package com.x.project.application.layer.business.generator.proxy.spring;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ConnectionFactory connectionFactory;

    @Bean
    public ProxyGeneratorService proxyGeneratorService() {
        final ProxyGeneratorServiceImpl proxyGeneratorService = new ProxyGeneratorServiceImpl();
        proxyGeneratorService.setConnectionFactory(this.connectionFactory);
        return proxyGeneratorService;
    }

}
