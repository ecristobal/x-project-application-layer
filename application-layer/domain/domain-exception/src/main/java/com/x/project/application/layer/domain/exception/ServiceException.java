package com.x.project.application.layer.domain.exception;

/**
 * Preactions' checked {@link Exception}.
 * 
 * @author Esteban Cristóbal
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = -4020436076154848563L;

	/**
	 * Class constructor.
	 * 
	 * @param message
	 *            exception message
	 */
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * Class constructor.
	 * 
	 * @param cause
	 *            exception cause
	 */
	public ServiceException(Throwable cause) {
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
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
