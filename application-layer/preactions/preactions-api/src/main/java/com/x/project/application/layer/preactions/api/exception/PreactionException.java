package com.x.project.application.layer.preactions.api.exception;

/**
 * Preactions' checked {@link Exception}.
 * 
 * @author Esteban Cristóbal
 */
public class PreactionException extends Exception {

    private static final long serialVersionUID = 2859229859103209153L;

    public PreactionException(String message) {
        super(message);
    }

    public PreactionException(Throwable cause) {
        super(cause);
    }

    public PreactionException(String message, Throwable cause) {
        super(message, cause);
    }

}
