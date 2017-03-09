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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((inputParameters == null) ? 0 : inputParameters.hashCode());
        result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PreactionContext other = (PreactionContext) obj;
        if (inputParameters == null) {
            if (other.inputParameters != null)
                return false;
        } else if (!inputParameters.equals(other.inputParameters))
            return false;
        if (requestId == null) {
            if (other.requestId != null)
                return false;
        } else if (!requestId.equals(other.requestId))
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PreactionContext [requestId=");
        builder.append(requestId);
        builder.append(", inputParameters=");
        builder.append(inputParameters);
        builder.append("]");
        return builder.toString();
    }

}
