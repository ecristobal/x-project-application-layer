package com.x.project.application.layer.chain.manager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.x.project.application.layer.chain.api.ChainHandler;
import com.x.project.application.layer.chain.exception.ChainException;
import com.x.project.application.layer.domain.context.Context;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/chain-manager-test.xml" })
public class ChainManagerTest {

    @Autowired
    private ChainHandler chainHandler;

    @Autowired
    private ChainManager chainManager;

    @Before
    public void setUp() throws ChainException {
        Mockito.when(this.chainHandler.handle(Mockito.any(Context.class))).thenAnswer(new Answer<Context>() {

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
