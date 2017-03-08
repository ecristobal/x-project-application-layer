package com.x.project.application.layer.domain.vo.parameter;

/**
 * Class that extends {@link AbstractParameterVo} to store {@link String}
 * parameters.
 * 
 * @author Esteban Cristóbal
 */
public class StringParameterVo extends AbstractParameterVo {

    private String value;

    /**
     * Class constructor.
     * 
     * @param name
     *            parameter name
     * @param value
     *            parameter value
     */
    public StringParameterVo(final String name, final String value) {
        super(name);
        this.value = value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.x.project.application.layer.domain.vo.parameter.AbstractParameterVo#
     * getValue()
     */
    @Override
    public String getValue() {
        return this.value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((value == null) ? 0 : value.hashCode());
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
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        StringParameterVo other = (StringParameterVo) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
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
        builder.append("StringParameterVo [value=");
        builder.append(value);
        builder.append(", name=");
        builder.append(super.getName());
        builder.append("]");
        return builder.toString();
    }

}
