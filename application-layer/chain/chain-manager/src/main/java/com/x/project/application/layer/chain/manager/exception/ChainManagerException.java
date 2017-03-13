package com.x.project.application.layer.chain.manager.exception;

/**
 * Preactions' checked {@link Exception}.
 * 
 * @author Esteban Cristóbal
 */
public class ChainManagerException extends Exception {

    private static final long serialVersionUID = 2859229859103209153L;

    /**
     * Class constructor.
     * 
     * @param message
     *            exception message
     */
    public ChainManagerException(String message) {
        super(message);
    }

    /**
     * Class constructor.
     * 
     * @param cause
     *            exception cause
     */
    public ChainManagerException(Throwable cause) {
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
    public ChainManagerException(String message, Throwable cause) {
        super(message, cause);
    }

}
