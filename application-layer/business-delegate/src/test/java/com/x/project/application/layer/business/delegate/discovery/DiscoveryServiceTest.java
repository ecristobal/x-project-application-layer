package com.x.project.application.layer.business.delegate.discovery;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/business-delegate.xml",
        "classpath:/spring/business-delegate-test.xml" })
public class DiscoveryServiceTest {

    @Resource(name = "discoveryClient")
    private DiscoveryClient discoveryClient;

    @Resource(name = "discoveryService")
    private DiscoveryService discoveryService;

    @Test
    public void testGetSingleEndpoint() throws URISyntaxException {
        final String endpoint = "http://www.google.es";
        final String serviceName = "test";
        final ServiceInstance mockServiceInstance = Mockito.mock(ServiceInstance.class);
        Mockito.when(mockServiceInstance.getUri()).thenReturn(new URI(endpoint));
        final List<ServiceInstance> serviceInstances = new ArrayList<ServiceInstance>(1);
        serviceInstances.add(mockServiceInstance);
        Mockito.when(this.discoveryClient.getInstances(Mockito.eq(serviceName))).thenReturn(serviceInstances);
        Assert.assertEquals(endpoint, this.discoveryService.getEndpoint(serviceName));
    }

    @Test
    public void testGetMultipleEndpoints() throws URISyntaxException {
        final String endpoint = "http://www.google.es/";
        final String serviceName = "test2";
        final List<ServiceInstance> serviceInstances = new ArrayList<ServiceInstance>(5);
        serviceInstances.add(this.createMockServiceInstance(endpoint));
        serviceInstances.add(this.createMockServiceInstance(endpoint));
        serviceInstances.add(this.createMockServiceInstance(endpoint));
        serviceInstances.add(this.createMockServiceInstance(endpoint));
        serviceInstances.add(this.createMockServiceInstance(endpoint));
        Mockito.when(this.discoveryClient.getInstances(Mockito.eq(serviceName))).thenReturn(serviceInstances);
        for (int i = 0; i < serviceInstances.size(); i++) {
            Assert.assertTrue(this.discoveryService.getEndpoint(serviceName).startsWith(endpoint));
        }
    }

    private ServiceInstance createMockServiceInstance(final String endpoint) throws URISyntaxException {
        final ServiceInstance mockServiceInstance = Mockito.mock(ServiceInstance.class);
        Mockito.when(mockServiceInstance.getUri()).thenReturn(new URI(endpoint.concat(String.valueOf(Math.random()))));
        return mockServiceInstance;
    }

}
