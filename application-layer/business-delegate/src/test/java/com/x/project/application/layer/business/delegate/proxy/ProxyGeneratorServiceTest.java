package com.x.project.application.layer.business.delegate.proxy;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.x.project.application.layer.business.delegate.discovery.DiscoveryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/business-delegate.xml",
        "classpath:/spring/business-delegate-test.xml" })
public class ProxyGeneratorServiceTest {

    @Resource(name = "proxyGeneratorService")
    private ProxyGeneratorService proxyGeneratorService;

    @Test
    public void testCreateJmsProxy() {
        final DiscoveryService discoveryService = this.proxyGeneratorService.createJmsProxy(DiscoveryService.class,
                "test");
        Assert.assertNotNull(discoveryService);
    }

    @Test
    public void testCreateHttpProxy() {
        final DiscoveryService discoveryService = this.proxyGeneratorService.createHttpProxy(DiscoveryService.class,
                "test");
        Assert.assertNotNull(discoveryService);
    }

}
