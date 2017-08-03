package com.tecnopyme.application.layer.chain.exception;

import com.tecnopyme.application.layer.domain.exception.ServiceRuntimeException;

/**
 * Chain unchecked {@link RuntimeException}.
 * 
 * @author Esteban Cristóbal
 */
public class ChainRuntimeException extends ServiceRuntimeException {

	private static final long serialVersionUID = 7345624675173933557L;

	/**
	 * Class constructor.
	 * 
	 * @param message
	 *            exception message
	 */
	public ChainRuntimeException(String message) {
		super(message);
	}

	/**
	 * Class constructor.
	 * 
	 * @param cause
	 *            exception cause
	 */
	public ChainRuntimeException(Throwable cause) {
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
	public ChainRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

}
