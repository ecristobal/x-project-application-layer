package com.x.project.application.layer.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Spring boot launcher class.
 * 
 * @author Esteban Cristóbal
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceApplication {

    /**
     * Main method.
     * 
     * @param args
     *            program arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication.class, args);
    }

}
