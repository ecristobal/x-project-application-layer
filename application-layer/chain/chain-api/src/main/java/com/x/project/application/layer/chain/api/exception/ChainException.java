package com.x.project.application.layer.chain.api.exception;

/**
 * Preactions' checked {@link Exception}.
 * 
 * @author Esteban Cristóbal
 */
public class ChainException extends Exception {

    private static final long serialVersionUID = 2859229859103209153L;

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
