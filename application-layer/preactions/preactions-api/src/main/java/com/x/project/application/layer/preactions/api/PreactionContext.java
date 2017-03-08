package com.x.project.application.layer.preactions.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.x.project.application.layer.domain.vo.parameter.AbstractParameterVo;

/**
 * Class that stores the context for the preactions.
 * 
 * @author Esteban Cristóbal
 */
public class PreactionContext {

    private String requestId;

    private List<AbstractParameterVo> inputParameters;

    /**
     * Class constructor.
     * 
     * @param requestId
     *            request ID associated with this context
     */
    public PreactionContext(final String requestId) {
        this.inputParameters = new ArrayList<AbstractParameterVo>();
        this.requestId = requestId;
    }

    /**
     * @return request ID
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * @return input parameter {@link Map}
     */
    public List<AbstractParameterVo> getInputParameters() {
        return inputParameters;
    }

}
