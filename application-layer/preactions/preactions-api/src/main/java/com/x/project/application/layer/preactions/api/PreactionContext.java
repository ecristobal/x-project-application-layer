package com.x.project.application.layer.preactions.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that stores the context for the preactions.
 * 
 * @author Esteban Cristóbal
 */
public class PreactionContext {

    private String requestId;

    private Map<String, Object> inputParameters;

    /**
     * Class constructor.
     * 
     * @param requestId
     *            request ID associated with this context
     */
    public PreactionContext(final String requestId) {
        this.inputParameters = new HashMap<String, Object>();
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
    public Map<String, Object> getInputParameters() {
        return inputParameters;
    }

}
