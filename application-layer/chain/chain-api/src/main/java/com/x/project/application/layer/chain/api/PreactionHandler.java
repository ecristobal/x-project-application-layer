package com.x.project.application.layer.chain.api;

import com.x.project.application.layer.chain.api.exception.PreactionException;
import com.x.project.application.layer.domain.context.Context;

/**
 * Interface to be implemented by all preactions on application layer.
 * 
 * This interface intends to be the <i>HandlerBase</i> of
 * <a href="http://www.blackwasp.co.uk/ChainOfResponsibility.aspx">Chain of
 * Responsibility</a> design pattern.
 * 
 * @author Esteban Cristóbal
 */
public interface PreactionHandler {

    /**
     * Entry method for every preaction.
     * 
     * @param preactionContext
     *            preaction context
     * @throws PreactionException
     *             in case of problems with preaction execution
     */
    void handle(final Context preactionContext) throws PreactionException;

}
