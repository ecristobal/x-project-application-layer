package com.x.project.application.layer.application.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.x.project.application.layer.application.service.mock.MockApiComponent;
import com.x.project.application.layer.application.service.spring.ApplicationServiceTestConfiguration;
import com.x.project.application.layer.domain.exception.ServiceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationServiceTestConfiguration.class })
public class ApplicationServiceTest {

    @Autowired
    private ApplicationService<MockApiComponent, MockApiComponent> applicationService;

    @Test
    public void testInvoke() throws ServiceException {
        final MockApiComponent apiComponent = new MockApiComponent("test");
        final MockApiComponent response = this.applicationService.invoke(apiComponent);
        Assert.assertEquals("testBusiness", response.getField());
    }

}
