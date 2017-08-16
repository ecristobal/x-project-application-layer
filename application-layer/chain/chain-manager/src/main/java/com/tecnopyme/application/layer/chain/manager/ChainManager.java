/*******************************************************************************
 * Copyright (c) 2017 TecnoPYME. All rights reserved
 ******************************************************************************/
package com.tecnopyme.application.layer.chain.manager;

import com.tecnopyme.application.layer.chain.exception.ChainException;
import com.tecnopyme.application.layer.domain.context.Context;

/**
 * Interface for the preactions manager service.
 * This interface intends to be the <i>Client</i> of
 * <a href="http://www.blackwasp.co.uk/ChainOfResponsibility.aspx">Chain of
 * Responsibility</a> design pattern.
 * 
 * @author Esteban Cristóbal
 */
@FunctionalInterface
public interface ChainManager {

	/**
	 * Launch the preactions chain of responsibility.
	 * 
	 * @param context
	 *            request context
	 * @return updated request context
	 * @throws ChainException
	 *             in case of errors during chain manager execution
	 */
	public Context executeChain(final Context context) throws ChainException;

}
