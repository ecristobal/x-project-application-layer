/*******************************************************************************
 * Copyright (c) 2017 TecnoPYME. All rights reserved
 ******************************************************************************/
package com.tecnopyme.application.layer.chain.exception;

import com.tecnopyme.application.layer.domain.exception.ServiceException;

/**
 * Chain checked {@link Exception}.
 * 
 * @author Esteban Cristóbal
 */
public class ChainException extends ServiceException {

	private static final long serialVersionUID = 3858478949165839459L;

	/**
	 * Class constructor.
	 * 
	 * @param message
	 *            exception message
	 */
	public ChainException(String message) {
		super(message);
	}

	/**
	 * Class constructor.
	 * 
	 * @param cause
	 *            exception cause
	 */
	public ChainException(Throwable cause) {
		super(cause);
	}

	/**
	 * Class constructor.
	 * 
	 * @param message
	 *            exception message
	 * @param cause
	 *            exception cause
	 */
	public ChainException(String message, Throwable cause) {
		super(message, cause);
	}

}
