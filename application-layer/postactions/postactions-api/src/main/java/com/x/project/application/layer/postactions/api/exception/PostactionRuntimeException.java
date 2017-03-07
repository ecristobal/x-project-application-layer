package com.x.project.application.layer.postactions.api.exception;

/**
 * Postactions' unchecked {@link RuntimeException}.
 * 
 * @author Esteban Cristóbal
 */
public class PostactionRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -6172115060120441492L;

    public PostactionRuntimeException(String message) {
        super(message);
    }

    public PostactionRuntimeException(Throwable cause) {
        super(cause);
    }

    public PostactionRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}
