package com.x.project.application.layer.chain.manager;

import com.x.project.application.layer.chain.api.exception.ChainHandlerException;
import com.x.project.application.layer.chain.exception.ChainException;
import com.x.project.application.layer.chain.manager.exception.ChainManagerException;
import com.x.project.application.layer.domain.context.Context;

/**
 * Interface for the preactions manager service.
 * 
 * This interface intends to be the <i>Client</i> of
 * <a href="http://www.blackwasp.co.uk/ChainOfResponsibility.aspx">Chain of
 * Responsibility</a> design pattern.
 * 
 * @author Esteban Cristóbal
 */
public interface ChainManager {

    /**
     * Launch the preactions chain of responsibility.
     * 
     * @param context
     *            request context
     * @return updated request context
     * @throws ChainManagerException
     *             in case of errors during chain manager execution
     * @throws ChainHandlerException
     *             in case of errors during chain handler execution
     */
    public Context executeChain(final Context context) throws ChainException;

}
