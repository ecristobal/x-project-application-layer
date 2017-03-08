package com.x.project.application.layer.postactions.api.exception;

/**
 * Postactions' checked {@link Exception}.
 * 
 * @author Esteban Cristóbal
 */
public class PostactionException extends Exception {

    private static final long serialVersionUID = -5703910441883970664L;

    /**
     * Class constructor.
     * 
     * @param message
     *            exception message
     */
    public PostactionException(String message) {
        super(message);
    }

    /**
     * Class constructor.
     * 
     * @param cause
     *            exception cause
     */
    public PostactionException(Throwable cause) {
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
    public PostactionException(String message, Throwable cause) {
        super(message, cause);
    }

}
