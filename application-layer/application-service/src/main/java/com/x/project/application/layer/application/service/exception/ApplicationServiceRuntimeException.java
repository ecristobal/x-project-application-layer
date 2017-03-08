package com.x.project.application.layer.application.service.exception;

/**
 * Application service unchecked {@link RuntimeException}.
 * 
 * @author Esteban Cristóbal
 */
public class ApplicationServiceRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -8948003942204630649L;

    /**
     * Class constructor.
     * 
     * @param message
     *            exception message
     */
    public ApplicationServiceRuntimeException(String message) {
        super(message);
    }

    /**
     * Class constructor.
     * 
     * @param cause
     *            exception cause
     */
    public ApplicationServiceRuntimeException(Throwable cause) {
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
    public ApplicationServiceRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}
