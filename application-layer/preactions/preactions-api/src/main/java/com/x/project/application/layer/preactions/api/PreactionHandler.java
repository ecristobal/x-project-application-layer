package com.x.project.application.layer.preactions.api;

import com.x.project.application.layer.preactions.api.exception.PreactionException;

/**
 * Interface to be implemented by all preactions on application layer.
 * 
 * @author Esteban Cristóbal
 */
public interface Preaction {

    /**
     * Entry method for every preaction.
     * 
     * @param preactionContext
     *            preaction context
     * @throws PreactionException
     *             in case of problems with preaction execution
     */
    void execute(final PreactionContext preactionContext) throws PreactionException;

}
