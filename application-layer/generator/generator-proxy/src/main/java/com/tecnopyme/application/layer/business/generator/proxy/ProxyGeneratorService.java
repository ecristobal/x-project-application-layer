/*******************************************************************************
 * Copyright (c) 2017 TecnoPYME. All rights reserved
 ******************************************************************************/
package com.tecnopyme.application.layer.business.generator.proxy;

/**
 * Utility class to manage creation of JAX-WR proxies.
 * 
 * @author Esteban Cristóbal
 */
@FunctionalInterface
public interface ProxyGeneratorService {

    /**
     * Creates a proxy service which routes request through a JMS queue.
     * 
     * @param <T>
     *            proxy interface
     * @param serviceClass
     *            service to be proxied
     * @param endpoint
     *            REST service host URL
     * @return REST proxy
     */
    public <T> T createProxy(final Class<T> serviceClass, final String endpoint);

}
