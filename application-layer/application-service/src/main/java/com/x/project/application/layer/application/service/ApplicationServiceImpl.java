package com.x.project.application.layer.application.service;

import com.x.project.application.layer.application.service.exception.ApplicationServiceException;
import com.x.project.application.layer.business.delegate.ServiceBusinessDelegate;
import com.x.project.application.layer.business.delegate.exception.BusinessLogicException;
import com.x.project.application.layer.domain.api.ApiComponent;

/**
 * Implementation of {@link ApplicationService} interface.
 * 
 * @author Esteban Cristóbal
 */
public class ApplicationServiceImpl<Tin extends ApiComponent, Tout extends ApiComponent>
        implements ApplicationService<Tin, Tout> {

    private ServiceBusinessDelegate<Tin, Tout> businessDelegate;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.x.project.application.layer.application.service.ApplicationService#
     * invoke(Tin)
     */
    public Tout invoke(final Tin inputParamters) throws ApplicationServiceException, BusinessLogicException {
        // TODO Implement method details
        final Tout response = this.businessDelegate.execute(inputParamters, "");
        return response;
    }

    /**
     * @param businessDelegate
     *            the businessDelegate to set
     */
    public void setBusinessDelegate(ServiceBusinessDelegate<Tin, Tout> businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

}
