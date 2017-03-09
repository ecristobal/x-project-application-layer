package com.x.project.application.layer.business.generator.proxy;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/generator-proxy.xml",
        "classpath:/spring/generator-proxy-test.xml" })
public class ProxyGeneratorServiceTest {

    @Resource(name = "proxyGeneratorService")
    private ProxyGeneratorService proxyGeneratorService;

    @Test
    public void testCreateJmsProxy() {
        final List proxyService = this.proxyGeneratorService.createJmsProxy(List.class, "test");
        Assert.assertNotNull(proxyService);
        Assert.assertTrue(proxyService instanceof List);
    }

}
