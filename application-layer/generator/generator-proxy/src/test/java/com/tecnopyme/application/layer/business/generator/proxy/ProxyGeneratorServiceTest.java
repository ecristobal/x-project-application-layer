/*******************************************************************************
 * Copyright (c) 2017 TecnoPYME. All rights reserved
 ******************************************************************************/
package com.tecnopyme.application.layer.business.generator.proxy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tecnopyme.application.layer.business.generator.proxy.ProxyGeneratorService;
import com.tecnopyme.application.layer.business.generator.proxy.spring.ProxyGeneratorBeanConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ProxyGeneratorBeanConfiguration.class })
public class ProxyGeneratorServiceTest {

    @Autowired
    private ProxyGeneratorService proxyGeneratorService;

    @Test
    public void testCreateProxy() {
        final TestRestService proxyService = this.proxyGeneratorService.createProxy(TestRestService.class, "test");
        Assert.assertNotNull(proxyService);
        Assert.assertTrue(proxyService instanceof TestRestService);
    }
    
    @Path("/test")
    private interface TestRestService {
        
        @GET
        public void method(final @PathParam("param") String parameter);
    }

}
