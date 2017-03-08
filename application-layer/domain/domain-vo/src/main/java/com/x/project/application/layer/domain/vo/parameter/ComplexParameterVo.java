package com.x.project.application.layer.domain.vo.parameter;

import java.util.List;

/**
 * Class that extends {@link AbstractParameterVo} to store parameters formed by
 * a list of {@link AbstractParameterVo}.
 * 
 * @author Esteban Cristóbal
 */
public class ComplexParameterVo extends AbstractParameterVo {

    private List<AbstractParameterVo> parameterList;

    /**
     * Class constructor.
     * 
     * @param name
     *            parameter name
     * @param parameterList
     *            parameter {@link List}
     */
    public ComplexParameterVo(final String name, final List<AbstractParameterVo> parameterList) {
        super(name);
        this.parameterList = parameterList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.x.project.application.layer.domain.vo.parameter.AbstractParameterVo#
     * getValue()
     */
    @Override
    public List<AbstractParameterVo> getValue() {
        return this.parameterList;
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
        result = prime * result + ((parameterList == null) ? 0 : parameterList.hashCode());
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
        ComplexParameterVo other = (ComplexParameterVo) obj;
        if (parameterList == null) {
            if (other.parameterList != null)
                return false;
        } else if (!parameterList.equals(other.parameterList))
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
        builder.append("ComplexParameterVo [parameterList=");
        builder.append(parameterList);
        builder.append(", name()=");
        builder.append(super.getName());
        builder.append("]");
        return builder.toString();
    }

}
