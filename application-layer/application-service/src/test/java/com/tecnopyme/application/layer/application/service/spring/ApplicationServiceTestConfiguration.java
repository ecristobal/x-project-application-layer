/*******************************************************************************
 * Copyright (c) 2017 TecnoPYME. All rights reserved
 ******************************************************************************/
package com.tecnopyme.application.layer.application.service.spring;

import org.springframework.context.annotation.Bean;

import com.tecnopyme.application.layer.application.service.mock.MockApiComponent;
import com.tecnopyme.application.layer.application.service.mock.MockBusinessDelegate;
import com.tecnopyme.application.layer.application.service.mock.MockChainManager;
import com.tecnopyme.application.layer.business.delegate.AbstractBusinessDelegate;
import com.tecnopyme.application.layer.chain.manager.ChainManager;

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
