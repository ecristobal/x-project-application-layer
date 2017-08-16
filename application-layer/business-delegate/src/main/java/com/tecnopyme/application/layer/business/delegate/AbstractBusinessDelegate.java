/*******************************************************************************
 * Copyright (c) 2017 TecnoPYME. All rights reserved
 ******************************************************************************/
package com.tecnopyme.application.layer.business.delegate;

import com.tecnopyme.application.layer.business.delegate.discovery.DiscoveryService;
import com.tecnopyme.application.layer.business.delegate.exception.BusinessLogicException;
import com.tecnopyme.application.layer.business.generator.proxy.ProxyGeneratorService;
import com.tecnopyme.application.layer.domain.api.ApiComponent;

/**
 * Abstract class to be expanded with the business logic of services.
 * This class is intended to be the <i>BusinessDelegate</i> implementation of
 * <a href= "http://www.corej2eepatterns.com/BusinessDelegate.htm">Business
 * Delegate</a> design pattern.
 * This class will contain an <i>execute</i> with the business logic and as many
 * utility methods as needed to help developers to implement it.
 * 
 * @param <T>
 *            {@link ApiComponent} subclass which maps the service's input
 *            parameters
 * @param <V>
 *            {@link ApiComponent} subclass which maps the service's output
 *            parameters
 * @author Esteban Cristóbal
 */
public abstract class AbstractBusinessDelegate<T extends ApiComponent, V extends ApiComponent> {

	protected DiscoveryService discoveryService;

	protected ProxyGeneratorService proxyGeneratorService;

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
	public abstract V execute(final T inputParamters, final String requestId) throws BusinessLogicException;

	/**
	 * @param discoveryService
	 *            the discoveryService to set
	 */
	public void setDiscoveryService(DiscoveryService discoveryService) {
		this.discoveryService = discoveryService;
	}

	/**
	 * @param proxyGeneratorService
	 *            the proxyGeneratorService to set
	 */
	public void setProxyGeneratorService(ProxyGeneratorService proxyGeneratorService) {
		this.proxyGeneratorService = proxyGeneratorService;
	}

}
