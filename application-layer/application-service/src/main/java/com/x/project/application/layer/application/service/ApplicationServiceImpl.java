package com.x.project.application.layer.application.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.x.project.application.layer.application.service.exception.ApplicationServiceException;
import com.x.project.application.layer.business.delegate.AbstractBusinessDelegate;
import com.x.project.application.layer.business.delegate.exception.BusinessLogicException;
import com.x.project.application.layer.chain.manager.ChainManager;
import com.x.project.application.layer.domain.api.ApiComponent;
import com.x.project.application.layer.domain.context.Context;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationServiceImpl.class);

    private AbstractBusinessDelegate<T, V> businessDelegate;

    private ChainManager preactionsChain;

    private ChainManager postactionsChain;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.x.project.application.layer.application.service.ApplicationService#
     * invoke(Tin)
     */
    @SuppressWarnings("unchecked")
    public V invoke(final T inputParamters) throws ApplicationServiceException, BusinessLogicException {
        final String requestId = UUID.randomUUID().toString();
        LOGGER.debug("Request identified with ID {}", requestId);
        Context context = new Context(requestId, inputParamters);
        context = this.preactionsChain.executeChain(context);
        final V response = this.businessDelegate.execute(inputParamters, requestId);
        context.setResponseParameters(response);
        context = this.postactionsChain.executeChain(context);
        return (V) context.getResponseParameters();
    }

    /**
     * @param businessDelegate
     *            the businessDelegate to set
     */
    public void setBusinessDelegate(AbstractBusinessDelegate<T, V> businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    /**
     * @param preactionsChain
     *            the preactionsChain to set
     */
    public void setPreactionsChain(ChainManager preactionsChain) {
        this.preactionsChain = preactionsChain;
    }

    /**
     * @param postactionsChain
     *            the postactionsChain to set
     */
    public void setPostactionsChain(ChainManager postactionsChain) {
        this.postactionsChain = postactionsChain;
    }

}
