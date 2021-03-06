/*******************************************************************************
 * Copyright (c) 2017 TecnoPYME. All rights reserved
 ******************************************************************************/
package com.tecnopyme.application.layer.application.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tecnopyme.application.layer.business.delegate.AbstractBusinessDelegate;
import com.tecnopyme.application.layer.chain.manager.ChainManager;
import com.tecnopyme.application.layer.domain.api.ApiComponent;
import com.tecnopyme.application.layer.domain.context.Context;
import com.tecnopyme.application.layer.domain.exception.ServiceException;

/**
 * Implementation of {@link ApplicationService} interface.
 * 
 * @param <T>
 *            {@link ApiComponent} subclass which maps the service's input
 *            parameters
 * @param <V>
 *            {@link ApiComponent} subclass which maps the service's output
 *            parameters
 * @author Esteban Cristóbal
 */
public class ApplicationServiceImpl<T extends ApiComponent, V extends ApiComponent>
        implements ApplicationService<T, V> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationServiceImpl.class);

	private AbstractBusinessDelegate<T, V> businessDelegate;

	private ChainManager preactionsChain;

	private ChainManager postactionsChain;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.x.project.application.layer.application.service.ApplicationService#
	 * invoke(com.x.project.application.layer.domain.api.ApiComponent)
	 */
	@SuppressWarnings("unchecked")
	public V invoke(final T inputParamters) throws ServiceException {
		// Create request identifier
		final String requestId = UUID.randomUUID().toString();
		LOGGER.debug("Request identified with ID {}", requestId);
		// Context creation and preactions execution
		Context context = new Context(requestId, inputParamters);
		LOGGER.debug("Running preactions for request {}", requestId);
		context = this.preactionsChain.executeChain(context);
		LOGGER.debug("Successfully executed preactions for request {}", requestId);
		// Business logic execution
		LOGGER.debug("Running business logic for request {}", requestId);
		final V response = this.businessDelegate.execute((T) context.getRequestParameters(), requestId);
		LOGGER.debug("Successfully executed business logic for request {}", requestId);
		// Context update with business logic results and postactions execution
		context.setResponseParameters(response);
		LOGGER.debug("Running posactions for request {}", requestId);
		context = this.postactionsChain.executeChain(context);
		LOGGER.debug("Successfully executed postactions for request {}", requestId);
		// Returning response to client
		return (V) context.getResponseParameters();
	}

	/**
	 * @param businessDelegate
	 *            the businessDelegate to set
	 */
	public void setBusinessDelegate(AbstractBusinessDelegate<T, V> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	/**
	 * @param preactionsChain
	 *            the preactionsChain to set
	 */
	public void setPreactionsChain(ChainManager preactionsChain) {
		this.preactionsChain = preactionsChain;
	}

	/**
	 * @param postactionsChain
	 *            the postactionsChain to set
	 */
	public void setPostactionsChain(ChainManager postactionsChain) {
		this.postactionsChain = postactionsChain;
	}

}
