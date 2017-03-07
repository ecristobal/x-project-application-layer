package com.x.project.application.layer.authentication.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

/**
 * Spring boot launcher class.
 * 
 * @author Esteban Cristóbal
 */
@SpringBootApplication
@EnableDiscoveryClient
@ImportResource("classpath:/META-INF/spring/authentication-manager*.xml")
public class AuthenticationManagerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationManagerApplication.class);

    public static void main(String[] args) {
        LOGGER.debug("Starting authentication app");
        SpringApplication.run(AuthenticationManagerApplication.class, args);
        LOGGER.debug("Stopping authentication app");
    }

}
