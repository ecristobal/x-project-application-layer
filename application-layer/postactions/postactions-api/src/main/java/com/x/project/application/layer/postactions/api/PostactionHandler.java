package com.x.project.application.layer.postactions.api;

import com.x.project.application.layer.postactions.api.exception.PostactionException;

/**
 * Interface to be implemented by all postactions on application layer.
 * 
 * @author Esteban Cristóbal
 */
public interface Postaction {

    /**
     * Entry method for every postaction.
     * 
     * @param postactionContext
     *            postaction context
     * @throws PostactionException
     *             in case of problems with postaction execution
     */
    void execute(final PostactionContext postactionContext) throws PostactionException;

}
