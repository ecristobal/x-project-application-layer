package com.x.project.application.layer.business.generator.proxy;

/**
 * Utility class to manage creation of JAX-WS proxies with JMS
 * transport protocol.
 * 
 * @author Esteban Cristóbal
 */
public interface ProxyGeneratorService {

    /**
     * Creates a proxy service which routes request through a JMS queue.
     * 
     * @param serviceClass
     *            service to be proxied
     * @param queueName
     *            JMS queue which transports the request
     * @return SOAP-JMS proxy
     */
    public <T> T createJmsProxy(final Class<T> serviceClass, final String queueName);

}
