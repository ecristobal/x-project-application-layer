package com.x.project.application.layer.postactions.api;

import java.util.ArrayList;
import java.util.List;

import com.x.project.application.layer.domain.vo.parameter.AbstractParameterVo;

/**
 * Class that stores the context for the postactions.
 * 
 * @author Esteban Cristóbal
 */
public class PostactionContext {

    private String requestId;

    private List<AbstractParameterVo> outputParameters;

    /**
     * Class constructor.
     * 
     * @param requestId
     *            request ID associated with this context
     */
    public PostactionContext(final String requestId) {
        this.outputParameters = new ArrayList<AbstractParameterVo>();
        this.requestId = requestId;
    }

    /**
     * @return request ID
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * @return output parameter {@link List}
     */
    public List<AbstractParameterVo> getOutputParameters() {
        return outputParameters;
    }

}
