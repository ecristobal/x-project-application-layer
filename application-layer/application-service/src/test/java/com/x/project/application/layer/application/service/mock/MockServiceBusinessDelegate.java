package com.x.project.application.layer.application.service.mock;

import com.x.project.application.layer.business.delegate.AbstractBusinessDelegate;
import com.x.project.application.layer.business.delegate.exception.BusinessLogicException;

public class MockServiceBusinessDelegate extends AbstractBusinessDelegate<MockApiComponent, MockApiComponent> {

    @Override
    public MockApiComponent execute(MockApiComponent inputParamters, String requestId) throws BusinessLogicException {
        return inputParamters;
    }

}
