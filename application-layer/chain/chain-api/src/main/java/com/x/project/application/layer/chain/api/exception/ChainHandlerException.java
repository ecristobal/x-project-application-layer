package com.x.project.application.layer.chain.api.exception;

import com.x.project.application.layer.chain.exception.ChainException;

/**
 * Preactions' checked {@link Exception}.
 * 
 * @author Esteban Cristóbal
 */
public class ChainHandlerException extends ChainException {

    private static final long serialVersionUID = 2859229859103209153L;

    /**
     * Class constructor.
     * 
     * @param message
     *            exception message
     */
    public ChainHandlerException(String message) {
        super(message);
    }

    /**
     * Class constructor.
     * 
     * @param cause
     *            exception cause
     */
    public ChainHandlerException(Throwable cause) {
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
    public ChainHandlerException(String message, Throwable cause) {
        super(message, cause);
    }

}
