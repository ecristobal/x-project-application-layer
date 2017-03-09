package com.x.project.application.layer.application.service;

import com.x.project.application.layer.application.service.exception.ApplicationServiceException;
import com.x.project.application.layer.business.delegate.AbstractBusinessDelegate;
import com.x.project.application.layer.business.delegate.exception.BusinessLogicException;
import com.x.project.application.layer.domain.api.ApiComponent;

/**
 * Implementation of {@link ApplicationService} interface.
 * 
 * @param <T>
 *            {@link ApiComponent} subclass which maps the service's input
 *            parameters
 * 
 * @param <V>
 *            {@link ApiComponent} subclass which maps the service's output
 *            parameters
 * 
 * @author Esteban Cristóbal
 */
public class ApplicationServiceImpl<T extends ApiComponent, V extends ApiComponent>
        implements ApplicationService<T, V> {

    private AbstractBusinessDelegate<T, V> businessDelegate;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.x.project.application.layer.application.service.ApplicationService#
     * invoke(Tin)
     */
    public V invoke(final T inputParamters) throws ApplicationServiceException, BusinessLogicException {
        // TODO Implement method details
        final V response = this.businessDelegate.execute(inputParamters, "");
        return response;
    }

    /**
     * @param businessDelegate
     *            the businessDelegate to set
     */
    public void setBusinessDelegate(AbstractBusinessDelegate<T, V> businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

}
