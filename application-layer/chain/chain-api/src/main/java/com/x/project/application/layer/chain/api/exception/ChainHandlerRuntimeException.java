package com.x.project.application.layer.chain.api.exception;

import com.x.project.application.layer.chain.exception.ChainRuntimeException;

/**
 * Preactions' unchecked {@link RuntimeException}.
 * 
 * @author Esteban Cristóbal
 */
public class ChainHandlerRuntimeException extends ChainRuntimeException {

    private static final long serialVersionUID = -6069878601451224324L;

    /**
     * Class constructor.
     * 
     * @param message
     *            exception message
     */
    public ChainHandlerRuntimeException(String message) {
        super(message);
    }

    /**
     * Class constructor.
     * 
     * @param cause
     *            exception cause
     */
    public ChainHandlerRuntimeException(Throwable cause) {
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
    public ChainHandlerRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}
