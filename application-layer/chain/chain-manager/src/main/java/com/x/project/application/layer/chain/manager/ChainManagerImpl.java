package com.x.project.application.layer.chain.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.x.project.application.layer.chain.api.ChainHandler;
import com.x.project.application.layer.chain.api.exception.ChainException;
import com.x.project.application.layer.chain.manager.exception.ChainManagerException;
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
     * 
     * @see
     * com.x.project.application.layer.chain.manager.ChainManager#executeChain(
     * com.x.project.application.layer.domain.context.Context)
     */
    @Override
    public Context executeChain(Context context) throws ChainManagerException {
        LOGGER.debug("Starting chain execution for request {}", context.getRequestId());
        Context finalContext;
        try {
            finalContext = this.chainHandler.handle(context);
        } catch (ChainException e) {
            LOGGER.error("Exception thrown during chain execution:\n", e);
            throw new ChainManagerException(e);
        }
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
