/*******************************************************************************
 * Copyright (c) 2017 TecnoPYME. All rights reserved
 ******************************************************************************/
package com.tecnopyme.application.layer.chain.manager;

import static org.mockito.Matchers.any;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tecnopyme.application.layer.chain.api.ChainHandler;
import com.tecnopyme.application.layer.chain.exception.ChainException;
import com.tecnopyme.application.layer.chain.manager.spring.ChainManagerBeanConfiguration;
import com.tecnopyme.application.layer.domain.context.Context;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ChainManagerBeanConfiguration.class })
public class ChainManagerTest {

    @Autowired
    private ChainManager chainManager;
    
    @MockBean
    private ChainHandler chainHandler;

    @Before
    public void setUp() throws ChainException {
        BDDMockito.given(this.chainHandler.handle(any())).willAnswer(new Answer<Context>() {

            @Override
            public Context answer(InvocationOnMock invocation) throws Throwable {
                return invocation.getArgumentAt(0, Context.class);
            }
        });
    }

    @Test
    public void testExecuteChain() throws ChainException {
        final Context context = Mockito.mock(Context.class);
        final Context responseContext = this.chainManager.executeChain(context);
        Assert.assertEquals(context, responseContext);
    }

}
