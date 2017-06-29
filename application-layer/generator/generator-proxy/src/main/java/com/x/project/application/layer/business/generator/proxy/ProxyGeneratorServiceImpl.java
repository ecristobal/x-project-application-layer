package com.x.project.application.layer.business.generator.proxy;

import javax.jms.ConnectionFactory;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.jms.ConnectionFactoryFeature;
import org.apache.cxf.transport.jms.spec.JMSSpecConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of {@link ProxyGeneratorService} interface.
 * 
 * @author Esteban Cristóbal
 */
public class ProxyGeneratorServiceImpl implements ProxyGeneratorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProxyGeneratorServiceImpl.class);

    private static final String SOAP_JMS_ADDRESS_TEMPLATE = "jms:queue:{}?jndiTransactionManager=atomikosTransactionManager";

    private ConnectionFactory connectionFactory;

    /*
     * (non-Javadoc)
     * @see com.x.project.application.layer.business.delegate.proxy.
     * ProxyGeneratorService#createJmsProxy(java.lang.Class, java.lang.String)
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T createJmsProxy(final Class<T> serviceClass, final String queueName) {
        LOGGER.debug("Creating proxy client for service class {}", serviceClass.getName());
        final JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setTransportId(JMSSpecConstants.SOAP_JMS_SPECIFICATION_TRANSPORTID);
        factoryBean.setAddress(SOAP_JMS_ADDRESS_TEMPLATE.replace("{}", queueName));
        factoryBean.setServiceClass(serviceClass);
        factoryBean.getFeatures().add(new ConnectionFactoryFeature(this.connectionFactory));
        final T serviceProxy = (T) factoryBean.create();
        LOGGER.debug("Successfully created proxy client for service class {}", serviceClass.getName());
        return serviceProxy;
    }

    /**
     * @param connectionFactory
     *            the connectionFactory to set
     */
    public void setConnectionFactory(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

}
