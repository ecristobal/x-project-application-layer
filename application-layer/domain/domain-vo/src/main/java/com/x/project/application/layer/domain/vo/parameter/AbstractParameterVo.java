package com.x.project.application.layer.domain.vo.parameter;

/**
 * Abstract class to define parameter types.
 * 
 * @author Esteban Cristóbal
 */
public abstract class AbstractParameterVo {

    private String name;

    /**
     * Class constructor.
     * 
     * @param name
     *            parameter name
     */
    public AbstractParameterVo(final String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    public abstract Object getValue();

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        AbstractParameterVo other = (AbstractParameterVo) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
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
        builder.append("AbstractParameterVo [name=");
        builder.append(name);
        builder.append("]");
        return builder.toString();
    }

}
