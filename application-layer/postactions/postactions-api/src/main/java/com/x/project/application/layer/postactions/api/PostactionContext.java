package com.x.project.application.layer.postactions.api;

import java.util.List;

import com.x.project.application.layer.domain.api.ApiComponent;

/**
 * Class that stores the context for the postactions.
 * 
 * @author Esteban Cristóbal
 */
public class PostactionContext {

    private String requestId;

    private ApiComponent outputParameters;

    /**
     * Class constructor.
     * 
     * @param requestId
     *            request ID associated with this context
     * @param outputParameters
     *            output parameters
     */
    public PostactionContext(final String requestId, final ApiComponent outputParameters) {
        this.outputParameters = outputParameters;
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
    public ApiComponent getOutputParameters() {
        return outputParameters;
    }

}
