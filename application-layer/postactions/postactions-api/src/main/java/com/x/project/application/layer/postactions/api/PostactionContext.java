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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((outputParameters == null) ? 0 : outputParameters.hashCode());
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
        PostactionContext other = (PostactionContext) obj;
        if (outputParameters == null) {
            if (other.outputParameters != null)
                return false;
        } else if (!outputParameters.equals(other.outputParameters))
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
        builder.append("PostactionContext [requestId=");
        builder.append(requestId);
        builder.append(", outputParameters=");
        builder.append(outputParameters);
        builder.append("]");
        return builder.toString();
    }

}
