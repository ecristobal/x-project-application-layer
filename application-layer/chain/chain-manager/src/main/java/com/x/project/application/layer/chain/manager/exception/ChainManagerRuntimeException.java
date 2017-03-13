package com.x.project.application.layer.chain.manager.exception;

/**
 * Preactions' unchecked {@link RuntimeException}.
 * 
 * @author Esteban Cristóbal
 */
public class ChainManagerRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -6069878601451224324L;

    /**
     * Class constructor.
     * 
     * @param message
     *            exception message
     */
    public ChainManagerRuntimeException(String message) {
        super(message);
    }

    /**
     * Class constructor.
     * 
     * @param cause
     *            exception cause
     */
    public ChainManagerRuntimeException(Throwable cause) {
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
    public ChainManagerRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}
