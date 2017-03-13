package com.x.project.application.layer.business.delegate.exception;

import com.x.project.application.layer.domain.exception.ServiceRuntimeException;

/**
 * Business logic unchecked {@link RuntimeException}.
 * 
 * This exception should be subclassed as needed by the developer in order to
 * enable a better response handling which provides as much information as
 * possible to the requester.
 * 
 * @author Esteban Cristóbal
 */
public class BusinessLogicRuntimeException extends ServiceRuntimeException {

    private static final long serialVersionUID = -3961607320663524113L;

    /**
     * Class constructor.
     * 
     * @param message
     *            exception message
     */
    public BusinessLogicRuntimeException(String message) {
        super(message);
    }

    /**
     * Class constructor.
     * 
     * @param cause
     *            exception cause
     */
    public BusinessLogicRuntimeException(Throwable cause) {
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
    public BusinessLogicRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}
