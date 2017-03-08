package com.x.project.application.layer.postactions.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that stores the context for the postactions.
 * 
 * @author Esteban Cristóbal
 */
public class PostactionContext {

    private String requestId;

    private Map<String, Object> outputParameters;

    /**
     * Class constructor.
     * 
     * @param requestId
     *            request ID associated with this context
     */
    public PostactionContext(final String requestId) {
        this.outputParameters = new HashMap<String, Object>();
        this.requestId = requestId;
    }

    /**
     * @return request ID
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * @return output parameter {@link Map}
     */
    public Map<String, Object> getOutputParameters() {
        return outputParameters;
    }

}
