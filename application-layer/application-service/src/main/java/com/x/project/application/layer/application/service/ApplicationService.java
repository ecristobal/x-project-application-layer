package com.x.project.application.layer.application.service;

import com.x.project.application.layer.application.service.exception.ApplicationServiceException;
import com.x.project.application.layer.business.delegate.exception.BusinessLogicException;
import com.x.project.application.layer.domain.api.ApiComponent;

/**
 * Interface intended to define the <i>ApplicationService</i> element of
 * <a href= "http://www.corej2eepatterns.com/ApplicationService.htm">Application
 * Service</a> design pattern.
 * 
 * @author Esteban Cristóbal
 */
public interface ApplicationService<Tin extends ApiComponent, Tout extends ApiComponent> {

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
     */
    Tout invoke(Tin inputParamters) throws ApplicationServiceException, BusinessLogicException;

}