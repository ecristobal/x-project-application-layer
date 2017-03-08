package com.x.project.application.layer.postactions.api;

import java.util.ArrayList;
import java.util.List;

import com.x.project.application.layer.domain.vo.parameter.ApiMapper;

/**
 * Class that stores the context for the postactions.
 * 
 * @author Esteban Cristóbal
 */
public class PostactionContext {

    private String requestId;

    private List<ApiMapper> outputParameters;

    /**
     * Class constructor.
     * 
     * @param requestId
     *            request ID associated with this context
     */
    public PostactionContext(final String requestId) {
        this.outputParameters = new ArrayList<ApiMapper>();
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
    public List<ApiMapper> getOutputParameters() {
        return outputParameters;
    }

}
