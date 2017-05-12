package com.x.project.application.layer.chain.api;

import com.x.project.application.layer.chain.exception.ChainException;
import com.x.project.application.layer.domain.context.Context;

/**
 * Interface to be implemented by all preactions on application layer.
 * This interface intends to be the <i>HandlerBase</i> of
 * <a href="http://www.blackwasp.co.uk/ChainOfResponsibility.aspx">Chain of
 * Responsibility</a> design pattern.
 * 
 * @author Esteban Cristóbal
 */
@FunctionalInterface
public interface ChainHandler {

	/**
	 * Entry method for every preaction.
	 * 
	 * @param preactionContext
	 *            preaction context
	 * @return updated request context
	 * @throws ChainException
	 *             in case of problems with preaction execution
	 */
	public Context handle(final Context preactionContext) throws ChainException;

}
