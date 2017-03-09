package com.x.project.application.layer.chain.api.exception;

/**
 * Preactions' checked {@link Exception}.
 * 
 * @author Esteban Cristóbal
 */
public class PreactionException extends Exception {

    private static final long serialVersionUID = 2859229859103209153L;

    /**
     * Class constructor.
     * 
     * @param message
     *            exception message
     */
    public PreactionException(String message) {
        super(message);
    }

    /**
     * Class constructor.
     * 
     * @param cause
     *            exception cause
     */
    public PreactionException(Throwable cause) {
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
    public PreactionException(String message, Throwable cause) {
        super(message, cause);
    }

}
