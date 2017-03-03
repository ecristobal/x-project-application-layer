package com.x.project.application.layer.authentication.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Spring boot launcher class.
 * 
 * @author Esteban Cristóbal
 */
@SpringBootApplication
@ImportResource("classpath:/META-INF/spring/authentication-manager*.xml")
public class AuthenticationManagerLauncher {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationManagerLauncher.class);

    public static void main(String[] args) {
        LOGGER.debug("Starting authentication app");
        SpringApplication.run(AuthenticationManagerLauncher.class, args);
        LOGGER.debug("Stopping authentication app");
    }

}
