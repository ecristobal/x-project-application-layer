/*******************************************************************************
 * Copyright (c) 2017 TecnoPYME. All rights reserved
 ******************************************************************************/
package com.tecnopyme.application.layer.application.service.mock;

import com.tecnopyme.application.layer.chain.exception.ChainException;
import com.tecnopyme.application.layer.chain.manager.ChainManager;
import com.tecnopyme.application.layer.domain.context.Context;

public class MockChainManager implements ChainManager {

    @Override
    public Context executeChain(Context context) throws ChainException {
        return context;
    }

}
