package com.x.project.application.layer.domain.exception;

/**
 * Main services unchecked {@link RuntimeException}.
 * 
 * @author Esteban Cristóbal
 */
public class ServiceRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -6576512155747316260L;

	/**
	 * Class constructor.
	 * 
	 * @param message
	 *            exception message
	 */
	public ServiceRuntimeException(String message) {
		super(message);
	}

	/**
	 * Class constructor.
	 * 
	 * @param cause
	 *            exception cause
	 */
	public ServiceRuntimeException(Throwable cause) {
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
	public ServiceRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

}
