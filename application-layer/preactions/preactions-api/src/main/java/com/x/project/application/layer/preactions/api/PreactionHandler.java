package com.x.project.application.layer.preactions.api;

import com.x.project.application.layer.domain.context.Context;
import com.x.project.application.layer.preactions.api.exception.PreactionException;

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
