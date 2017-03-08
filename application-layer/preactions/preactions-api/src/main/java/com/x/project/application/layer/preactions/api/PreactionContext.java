package com.x.project.application.layer.preactions.api;

import java.util.Map;

import com.x.project.application.layer.domain.api.ApiComponent;

/**
 * Class that stores the context for the preactions.
 * 
 * @author Esteban Cristóbal
 */
public class PreactionContext {

    private String requestId;

    private ApiComponent inputParameters;

    /**
     * Class constructor.
     * 
     * @param requestId
     *            request ID associated with this context
     * @param inputParameters
     *            input parameters
     */
    public PreactionContext(final String requestId, final ApiComponent inputParameters) {
        this.inputParameters = inputParameters;
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
    public ApiComponent getInputParameters() {
        return inputParameters;
    }

}
