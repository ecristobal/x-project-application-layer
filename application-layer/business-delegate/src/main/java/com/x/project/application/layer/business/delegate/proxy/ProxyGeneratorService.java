package com.x.project.application.layer.business.delegate.proxy;

/**
 * 
 * Utility class to manage creation of JAX-WS proxies with HTTP and JMS
 * transport protocols.
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

    /**
     * Creates a proxy service which routes request through HTTP.
     * 
     * @param serviceClass
     *            service to be proxied
     * @param endpoint
     *            URL where the service is published
     * @return SOAP-HTTP proxy
     */
    public <T> T createHttpProxy(final Class<T> serviceClass, final String endpoint);

}
