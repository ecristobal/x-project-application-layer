package com.tecnopyme.application.layer.business.delegate.discovery;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tecnopyme.application.layer.business.delegate.discovery.DiscoveryService;
import com.tecnopyme.application.layer.business.delegate.spring.BusinessDelegateBeanConfiguration;
import com.tecnopyme.application.layer.business.delegate.spring.BusinessDelegateTestConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BusinessDelegateBeanConfiguration.class, BusinessDelegateTestConfiguration.class })
public class DiscoveryServiceTest {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
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
        final int iterations = 100;
        final int numberOfEndpoints = iterations / 10;
        final Set<String> returnedEndpoints = new HashSet<String>(iterations);
        final List<ServiceInstance> serviceInstances = new ArrayList<ServiceInstance>(iterations);
        for (int i = 0; i < numberOfEndpoints; i++) {
            serviceInstances.add(this.createMockServiceInstance(endpoint));
        }
        Mockito.when(this.discoveryClient.getInstances(Mockito.eq(serviceName))).thenReturn(serviceInstances);
        for (int i = 0; i < iterations; i++) {
            returnedEndpoints.add(this.discoveryService.getEndpoint(serviceName));
        }
        Assert.assertEquals(numberOfEndpoints, returnedEndpoints.size());
    }

    private ServiceInstance createMockServiceInstance(final String endpoint) throws URISyntaxException {
        final ServiceInstance mockServiceInstance = Mockito.mock(ServiceInstance.class);
        Mockito.when(mockServiceInstance.getUri()).thenReturn(new URI(endpoint.concat(String.valueOf(Math.random()))));
        return mockServiceInstance;
    }

}
