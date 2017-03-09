package com.x.project.application.layer.domain.context;

import java.util.List;

import com.x.project.application.layer.domain.api.ApiComponent;

/**
 * Class that stores the context for the postactions.
 * 
 * @author Esteban Cristóbal
 */
public class Context {

    private String requestId;

    private ApiComponent requestParameters;

    private ApiComponent responseParameters;

    /**
     * Class constructor.
     * 
     * @param requestId
     *            request ID associated with this context
     * @param requestParameters
     *            output parameters
     */
    public Context(final String requestId, final ApiComponent requestParameters) {
        this.requestParameters = requestParameters;
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
    public ApiComponent getRequestParameters() {
        return requestParameters;
    }

    /**
     * @return the responseParameters
     */
    public ApiComponent getResponseParameters() {
        return responseParameters;
    }

    /**
     * @param responseParameters
     *            the responseParameters to set
     */
    public void setResponseParameters(ApiComponent responseParameters) {
        this.responseParameters = responseParameters;
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
        result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
        result = prime * result + ((requestParameters == null) ? 0 : requestParameters.hashCode());
        result = prime * result + ((responseParameters == null) ? 0 : responseParameters.hashCode());
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
        Context other = (Context) obj;
        if (requestId == null) {
            if (other.requestId != null)
                return false;
        } else if (!requestId.equals(other.requestId))
            return false;
        if (requestParameters == null) {
            if (other.requestParameters != null)
                return false;
        } else if (!requestParameters.equals(other.requestParameters))
            return false;
        if (responseParameters == null) {
            if (other.responseParameters != null)
                return false;
        } else if (!responseParameters.equals(other.responseParameters))
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
        builder.append("Context [requestId=");
        builder.append(requestId);
        builder.append(", requestParameters=");
        builder.append(requestParameters);
        builder.append(", responseParameters=");
        builder.append(responseParameters);
        builder.append("]");
        return builder.toString();
    }

}
