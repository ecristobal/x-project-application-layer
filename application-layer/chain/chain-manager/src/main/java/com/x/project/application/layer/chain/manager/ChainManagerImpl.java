package com.x.project.application.layer.chain.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.x.project.application.layer.chain.api.ChainHandler;
import com.x.project.application.layer.chain.exception.ChainException;
import com.x.project.application.layer.domain.context.Context;

/**
 * Implementation of {@link ChainManager} interface.
 * 
 * @author Esteban Cristóbal
 */
public class ChainManagerImpl implements ChainManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChainManagerImpl.class);

	private ChainHandler chainHandler;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.x.project.application.layer.chain.manager.ChainManager#executeChain(
	 * com.x.project.application.layer.domain.context.Context)
	 */
	@Override
	public Context executeChain(Context context) throws ChainException {
		LOGGER.debug("Starting chain execution for request {}", context.getRequestId());
		Context finalContext;
		finalContext = this.chainHandler.handle(context);
		LOGGER.debug("Successfully finished chain execution for request {}", context.getRequestId());
		return finalContext;
	}

	/**
	 * @param chainHandler
	 *            the chainHandler to set
	 */
	public void setChainHandler(ChainHandler chainHandler) {
		this.chainHandler = chainHandler;
	}

}
