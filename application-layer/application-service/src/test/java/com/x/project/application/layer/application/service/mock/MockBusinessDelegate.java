package com.x.project.application.layer.application.service.mock;

import com.x.project.application.layer.business.delegate.AbstractBusinessDelegate;
import com.x.project.application.layer.business.delegate.exception.BusinessLogicException;

public class MockBusinessDelegate extends AbstractBusinessDelegate<MockApiComponent, MockApiComponent> {

	@Override
	public MockApiComponent execute(MockApiComponent inputParameters, String requestId) throws BusinessLogicException {
	    inputParameters.setField(inputParameters.getField().concat("Business"));
		return inputParameters;
	}

}
