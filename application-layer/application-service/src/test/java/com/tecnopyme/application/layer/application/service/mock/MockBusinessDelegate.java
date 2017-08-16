/*******************************************************************************
 * Copyright (c) 2017 TecnoPYME. All rights reserved
 ******************************************************************************/
package com.tecnopyme.application.layer.application.service.mock;

import com.tecnopyme.application.layer.business.delegate.AbstractBusinessDelegate;
import com.tecnopyme.application.layer.business.delegate.exception.BusinessLogicException;

public class MockBusinessDelegate extends AbstractBusinessDelegate<MockApiComponent, MockApiComponent> {

	@Override
	public MockApiComponent execute(MockApiComponent inputParameters, String requestId) throws BusinessLogicException {
	    inputParameters.setField(inputParameters.getField().concat("Business"));
		return inputParameters;
	}

}
