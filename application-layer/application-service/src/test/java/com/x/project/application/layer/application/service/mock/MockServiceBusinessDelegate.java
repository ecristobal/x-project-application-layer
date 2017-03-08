package com.x.project.application.layer.application.service.mock;

import com.x.project.application.layer.business.delegate.ServiceBusinessDelegate;
import com.x.project.application.layer.business.delegate.exception.BusinessLogicException;

public class MockServiceBusinessDelegate extends ServiceBusinessDelegate<MockApiComponent, MockApiComponent> {

    @Override
    public MockApiComponent execute(MockApiComponent inputParamters, String requestId) throws BusinessLogicException {
        return inputParamters;
    }

}
