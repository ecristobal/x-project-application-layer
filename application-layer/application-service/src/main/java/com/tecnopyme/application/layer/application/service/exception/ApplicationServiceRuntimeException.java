/*******************************************************************************
 * Copyright (c) 2017 TecnoPYME. All rights reserved
 ******************************************************************************/
package com.tecnopyme.application.layer.application.service.exception;

import com.tecnopyme.application.layer.domain.exception.ServiceRuntimeException;

/**
 * Application service unchecked {@link RuntimeException}.
 * 
 * @author Esteban Cristóbal
 */
public class ApplicationServiceRuntimeException extends ServiceRuntimeException {

	private static final long serialVersionUID = -8948003942204630649L;

	/**
	 * Class constructor.
	 * 
	 * @param message
	 *            exception message
	 */
	public ApplicationServiceRuntimeException(String message) {
		super(message);
	}

	/**
	 * Class constructor.
	 * 
	 * @param cause
	 *            exception cause
	 */
	public ApplicationServiceRuntimeException(Throwable cause) {
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
	public ApplicationServiceRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

}
