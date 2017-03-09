package com.x.project.application.layer.postactions.api;

import com.x.project.application.layer.domain.context.Context;
import com.x.project.application.layer.postactions.api.exception.PostactionException;

/**
 * Interface to be implemented by all postactions on application layer.
 * 
 * This interface intends to be the <i>HandlerBase</i> of
 * <a href="http://www.blackwasp.co.uk/ChainOfResponsibility.aspx">Chain of
 * Responsibility</a> design pattern.
 * 
 * @author Esteban Cristóbal
 */
public interface PostactionHandler {

    /**
     * Entry method for every postaction.
     * 
     * @param postactionContext
     *            postaction context
     * @throws PostactionException
     *             in case of problems with postaction execution
     */
    void handle(final Context postactionContext) throws PostactionException;

}
