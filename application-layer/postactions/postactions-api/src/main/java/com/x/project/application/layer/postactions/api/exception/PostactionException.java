package com.x.project.application.layer.postactions.api.exception;

/**
 * Postactions' checked {@link Exception}.
 * 
 * @author Esteban Cristóbal
 */
public class PostactionException extends Exception {

    private static final long serialVersionUID = -5703910441883970664L;

    public PostactionException(String message) {
        super(message);
    }

    public PostactionException(Throwable cause) {
        super(cause);
    }

    public PostactionException(String message, Throwable cause) {
        super(message, cause);
    }

}
