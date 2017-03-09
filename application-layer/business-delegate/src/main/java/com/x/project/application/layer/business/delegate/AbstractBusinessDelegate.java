package com.x.project.application.layer.business.delegate;

import com.x.project.application.layer.business.delegate.discovery.DiscoveryService;
import com.x.project.application.layer.business.delegate.exception.BusinessLogicException;
import com.x.project.application.layer.domain.api.ApiComponent;

/**
 * Abstract class to be expanded with the business logic of services.
 * 
 * This class is intended to be the <i>BusinessDelegate</i> implementation of
 * <a href= "http://www.corej2eepatterns.com/BusinessDelegate.htm">Business
 * Delegate</a> design pattern.
 * 
 * This class will contain an <i>execute</i> with the business logic and as many
 * utility methods as needed to help developers to implement it.
 * 
 * @author Esteban Cristóbal
 */
public abstract class AbstractBusinessDelegate<Tin extends ApiComponent, Tout extends ApiComponent> {

    protected DiscoveryService discoveryService;

    /**
     * Abstract method to be implemented with the proper business logic.
     * 
     * @param inputParamters
     *            input parameters
     * @param requestId
     *            request ID
     * @return {@link ApiComponent} subclass which maps the response to be sent
     *         to the requester
     * @throws BusinessLogicException
     *             in case of errors during method execution
     */
    public abstract Tout execute(final Tin inputParamters, final String requestId) throws BusinessLogicException;

    /**
     * @param discoveryService
     *            the discoveryService to set
     */
    public void setDiscoveryService(DiscoveryService discoveryService) {
        this.discoveryService = discoveryService;
    }

}