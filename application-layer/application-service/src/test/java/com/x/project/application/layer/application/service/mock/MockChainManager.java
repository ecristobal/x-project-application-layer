package com.x.project.application.layer.application.service.mock;

import com.x.project.application.layer.chain.exception.ChainException;
import com.x.project.application.layer.chain.manager.ChainManager;
import com.x.project.application.layer.domain.context.Context;

public class MockChainManager implements ChainManager {

    @Override
    public Context executeChain(Context context) throws ChainException {
        return context;
    }

}
