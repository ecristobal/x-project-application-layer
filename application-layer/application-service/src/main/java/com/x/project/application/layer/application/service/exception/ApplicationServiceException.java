package com.x.project.application.layer.application.service.exception;

import com.x.project.application.layer.domain.exception.ServiceException;

/**
 * Application service checked {@link Exception}.
 * 
 * @author Esteban Cristóbal
 */
public class ApplicationServiceException extends ServiceException {

	private static final long serialVersionUID = -8591795279572936954L;

	/**
	 * Class constructor.
	 * 
	 * @param message
	 *            exception message
	 */
	public ApplicationServiceException(String message) {
		super(message);
	}

	/**
	 * Class constructor.
	 * 
	 * @param cause
	 *            exception cause
	 */
	public ApplicationServiceException(Throwable cause) {
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
	public ApplicationServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
