package com.x.project.application.layer.application.service.spring;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.x.project.application.layer.application.service.mock.MockApiComponent;
import com.x.project.application.layer.application.service.mock.MockBusinessDelegate;
import com.x.project.application.layer.business.delegate.AbstractBusinessDelegate;
import com.x.project.application.layer.chain.manager.ChainManager;

@Configuration
public class ApplicationServiceMockConfiguration {
    
    @Bean
    public AbstractBusinessDelegate<MockApiComponent, MockApiComponent> businessDelegate() {
        return new MockBusinessDelegate();
    }
    
    @Bean
    public ChainManager preactionsChain() {
        return Mockito.mock(ChainManager.class);
    }
    
    @Bean
    public ChainManager postactionsChain() {
        return Mockito.mock(ChainManager.class);
    }

}
