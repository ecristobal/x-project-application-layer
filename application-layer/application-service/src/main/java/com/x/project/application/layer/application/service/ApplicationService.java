package com.x.project.application.layer.application.service;

import com.x.project.application.layer.application.service.exception.ApplicationServiceException;
import com.x.project.application.layer.business.delegate.exception.BusinessLogicException;
import com.x.project.application.layer.chain.exception.ChainException;
import com.x.project.application.layer.domain.api.ApiComponent;
import com.x.project.application.layer.domain.exception.ServiceException;

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
 * @author Esteban Cristóbal
 */
@FunctionalInterface
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
	 *             in case of problems with service execution
	 * @throws BusinessLogicException
	 *             in case of problems with business logic execution
	 * @throws ChainException
	 *             in case of problems with preactions or pastactions execution
	 */
	V invoke(T inputParamters) throws ServiceException;

}