package com.x.project.application.layer.application.service.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.x.project.application.layer.application.service.ApplicationService;
import com.x.project.application.layer.application.service.ApplicationServiceImpl;
import com.x.project.application.layer.business.delegate.AbstractBusinessDelegate;
import com.x.project.application.layer.chain.manager.ChainManager;
import com.x.project.application.layer.domain.api.ApiComponent;

/**
 * Default application service bean definition class. Should be extended to
 * generate {@link ApplicationService} instance properly.
 * 
 * @author Esteban Cristóbal
 */
public abstract class DefaultApplicationServiceBeanConfiguration<T extends ApiComponent, V extends ApiComponent> {

    @Bean
    public ApplicationService<T, V> applicationService(@Autowired final AbstractBusinessDelegate<T, V> businessDelegate,
            @Autowired final ChainManager preactionsChain, @Autowired final ChainManager postactionsChain) {
        final ApplicationServiceImpl<T, V> applicationService = new ApplicationServiceImpl<>();
        applicationService.setBusinessDelegate(businessDelegate);
        applicationService.setPreactionsChain(preactionsChain);
        applicationService.setPostactionsChain(postactionsChain);
        return applicationService;
    }

}
