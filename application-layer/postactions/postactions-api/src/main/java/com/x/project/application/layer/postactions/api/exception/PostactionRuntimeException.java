package com.x.project.application.layer.postactions.api.exception;

/**
 * Postactions' unchecked {@link RuntimeException}.
 * 
 * @author Esteban Cristóbal
 */
public class PostactionRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -6172115060120441492L;

    /**
     * Class constructor.
     * 
     * @param message
     *            exception message
     */
    public PostactionRuntimeException(String message) {
        super(message);
    }

    /**
     * Class constructor.
     * 
     * @param cause
     *            exception cause
     */
    public PostactionRuntimeException(Throwable cause) {
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
    public PostactionRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}
