package com.x.project.application.layer.business.generator.proxy;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of {@link ProxyGeneratorService} interface.
 * 
 * @author Esteban Cristóbal
 */
public class ProxyGeneratorServiceImpl implements ProxyGeneratorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProxyGeneratorServiceImpl.class);

    /*
     * (non-Javadoc)
     * @see com.x.project.application.layer.business.generator.proxy.ProxyGeneratorService#createProxy(java.lang.Class,
     * java.lang.String)
     */
    @Override
    public <T> T createProxy(final Class<T> serviceClass, final String endpoint) {
        LOGGER.debug("Creating proxy client for service class {}", serviceClass.getName());
        final T serviceProxy = JAXRSClientFactory.create(endpoint, serviceClass);
        LOGGER.debug("Successfully created proxy client for service class {}", serviceClass.getName());
        return serviceProxy;
    }

}
