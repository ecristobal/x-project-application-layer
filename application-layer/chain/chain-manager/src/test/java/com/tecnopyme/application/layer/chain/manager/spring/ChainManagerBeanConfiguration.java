/*******************************************************************************
 * Copyright (c) 2017 TecnoPYME. All rights reserved
 ******************************************************************************/
package com.tecnopyme.application.layer.chain.manager.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tecnopyme.application.layer.chain.api.ChainHandler;
import com.tecnopyme.application.layer.chain.manager.ChainManager;
import com.tecnopyme.application.layer.chain.manager.ChainManagerImpl;

@Configuration
public class ChainManagerBeanConfiguration {

    @Bean
    public ChainManager chainManager(final ChainHandler chainHandler) {
        final ChainManagerImpl chainManager = new ChainManagerImpl();
        chainManager.setChainHandler(chainHandler);
        return chainManager;
    }

}
