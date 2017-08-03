package com.x.project.application.layer.application.service.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.x.project.application.layer.application.service.ApplicationService;
import com.x.project.application.layer.application.service.ApplicationServiceImpl;
import com.x.project.application.layer.business.delegate.AbstractBusinessDelegate;
import com.x.project.application.layer.chain.manager.ChainManager;
import com.x.project.application.layer.domain.api.ApiComponent;

/**
 * Default application service bean definition class. Should be extended to
 * generate {@link ApplicationService} instance properly.
 * 
 * @param <T>
 *            input API class (implements {@link ApiComponent} interface)
 * @param <V>
 *            output API class (implements {@link ApiComponent} interface)
 * @author Esteban Cristóbal
 */
@Configuration
public abstract class DefaultApplicationServiceBeanConfiguration<T extends ApiComponent, V extends ApiComponent> {

    /**
     * @param businessDelegate
     *            {@link AbstractBusinessDelegate} instance
     * @param preactionsChain
     *            {@link ChainManager} implementing service preactions
     * @param postactionsChain
     *            {@link ChainManager} implementing service postactions
     * @return {@link ApplicationService} instance
     */
    @Bean
    public ApplicationService<T, V> applicationService(final AbstractBusinessDelegate<T, V> businessDelegate,
            final ChainManager preactionsChain, final ChainManager postactionsChain) {
        final ApplicationServiceImpl<T, V> applicationService = new ApplicationServiceImpl<>();
        applicationService.setBusinessDelegate(businessDelegate);
        applicationService.setPreactionsChain(preactionsChain);
        applicationService.setPostactionsChain(postactionsChain);
        return applicationService;
    }

}
