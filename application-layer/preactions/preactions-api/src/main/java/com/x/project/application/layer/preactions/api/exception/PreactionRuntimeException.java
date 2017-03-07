package com.x.project.application.layer.preactions.api.exception;

/**
 * Preactions' unchecked {@link RuntimeException}.
 * 
 * @author Esteban Cristóbal
 */
public class PreactionRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -6069878601451224324L;

    public PreactionRuntimeException(String message) {
        super(message);
    }

    public PreactionRuntimeException(Throwable cause) {
        super(cause);
    }

    public PreactionRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}
