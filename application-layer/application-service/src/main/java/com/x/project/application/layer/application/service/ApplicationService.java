package com.x.project.application.layer.application.service;

import com.x.project.application.layer.application.service.exception.ApplicationServiceException;
import com.x.project.application.layer.business.delegate.exception.BusinessLogicException;
import com.x.project.application.layer.chain.api.exception.ChainException;
import com.x.project.application.layer.domain.api.ApiComponent;

/**
 * Interface intended to define the <i>ApplicationService</i> element of
 * <a href= "http://www.corej2eepatterns.com/ApplicationService.htm">Application
 * Service</a> design pattern.
 * 
 * @param <T>
 *            {@link ApiComponent} subclass which maps the service's input
 *            parameters
 * @param <V>
 *            {@link ApiComponent} subclass which maps the service's output
 *            parameters
 * 
 * @author Esteban Cristóbal
 */
public interface ApplicationService<T extends ApiComponent, V extends ApiComponent> {

    /**
     * Performs the operations related with the service execution requested by
     * the client.
     * 
     * @param inputParamters
     *            input parameters
     * @return {@link ApiComponent} subclass with the response to be sent to the
     *         client
     * @throws ApplicationServiceException
     *             in case of problems with non-business logic operations
     * @throws BusinessLogicException
     *             in case of problems with business logic operations
     * @throws ChainException
     *             in case of problems with preactions' or postactions'
     *             executions
     */
    V invoke(T inputParamters) throws ApplicationServiceException, BusinessLogicException, ChainException;

}