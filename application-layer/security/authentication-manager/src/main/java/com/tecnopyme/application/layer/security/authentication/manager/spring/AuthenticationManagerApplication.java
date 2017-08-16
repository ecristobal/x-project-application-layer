/*******************************************************************************
 * Copyright (c) 2017 TecnoPYME. All rights reserved
 ******************************************************************************/
package com.tecnopyme.application.layer.security.authentication.manager.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Spring boot launcher class.
 * 
 * @author Esteban Cristóbal
 */
@SpringBootApplication
@EnableEurekaClient
public class AuthenticationManagerApplication {

    /**
     * Main method.
     * 
     * @param args
     *            program arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(AuthenticationManagerApplication.class, args);
    }

}
