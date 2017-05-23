package com.x.project.application.layer.application.service.spring;

import org.springframework.context.annotation.Bean;

import com.x.project.application.layer.application.service.mock.MockApiComponent;
import com.x.project.application.layer.application.service.mock.MockBusinessDelegate;
import com.x.project.application.layer.application.service.mock.MockChainManager;
import com.x.project.application.layer.business.delegate.AbstractBusinessDelegate;
import com.x.project.application.layer.chain.manager.ChainManager;

public class ApplicationServiceTestConfiguration
        extends DefaultApplicationServiceBeanConfiguration<MockApiComponent, MockApiComponent> {

    @Bean
    public AbstractBusinessDelegate<MockApiComponent, MockApiComponent> businessDelegate() {
        return new MockBusinessDelegate();
    }

    @Bean
    public ChainManager preactionsChain() {
        return new MockChainManager();
    }

    @Bean
    public ChainManager postactionsChain() {
        return new MockChainManager();
    }

}
