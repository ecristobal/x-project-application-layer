package com.x.project.application.layer.chain.api.exception;

/**
 * Preactions' unchecked {@link RuntimeException}.
 * 
 * @author Esteban Cristóbal
 */
public class PreactionRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -6069878601451224324L;

    /**
     * Class constructor.
     * 
     * @param message
     *            exception message
     */
    public PreactionRuntimeException(String message) {
        super(message);
    }

    /**
     * Class constructor.
     * 
     * @param cause
     *            exception cause
     */
    public PreactionRuntimeException(Throwable cause) {
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
    public PreactionRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}
