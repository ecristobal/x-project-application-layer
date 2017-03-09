package com.x.project.application.layer.business.generator.proxy;

import javax.jms.ConnectionFactory;

import org.apache.cxf.binding.soap.SoapBindingConfiguration;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.jms.JMSConfigFeature;
import org.apache.cxf.transport.jms.JMSConfiguration;
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

    private ConnectionFactory connectionFactory;

    /*
     * (non-Javadoc)
     * 
     * @see com.x.project.application.layer.business.delegate.proxy.
     * ProxyGeneratorService#createJmsProxy(java.lang.Class, java.lang.String)
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T createJmsProxy(final Class<T> serviceClass, final String queueName) {
        LOGGER.debug("Creating proxy client for service class {}", serviceClass.getName());
        // Web Service proxy factory creation
        final JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        // Setting JMS as transport protocol
        factoryBean.setTransportId(JMSSpecConstants.SOAP_JMS_SPECIFICATION_TRANSPORTID);
        factoryBean.setAddress("jms://");
        // Setting Web Service interface
        factoryBean.setServiceClass(serviceClass);
        // Web Service JMS configuration
        final JMSConfiguration jmsConfiguration = new JMSConfiguration();
        jmsConfiguration.setConnectionFactory(this.connectionFactory);
        jmsConfiguration.setTargetDestination(queueName);
        jmsConfiguration.setReceiveTimeout(10000L);
        // Set JMS configuration for Web Service proxy
        final JMSConfigFeature jmsConfigFeature = new JMSConfigFeature();
        jmsConfigFeature.setJmsConfig(jmsConfiguration);
        // Add JMS and SOAP configuration
        factoryBean.getFeatures().add(jmsConfigFeature);
        SoapBindingConfiguration sbc = new SoapBindingConfiguration();
        factoryBean.setBindingConfig(sbc);
        // Web Service proxy creation
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
