package com.x.project.application.layer.authentication.manager.spring;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.apache.cxf.rs.security.oauth2.grants.clientcred.ClientCredentialsGrantHandler;
import org.apache.cxf.rs.security.oauth2.provider.OAuthDataProvider;
import org.apache.cxf.rs.security.oauth2.provider.OAuthJSONProvider;
import org.apache.cxf.rs.security.oauth2.services.AccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.x.project.application.layer.authentication.manager.provider.JwtOauthCustomProvider;

/**
 * Spring bean configuration class.
 * 
 * @author Esteban Cristóbal
 */
@Configuration
@EnableTransactionManagement
@EntityScan({ "org.apache.cxf.rs.security.oauth2.common", "org.apache.cxf.rs.security.oauth2.grants",
        "org.apache.cxf.rs.security.oauth2.tokens" })
public class AuthenticationManagerBeanConfiguration {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private Bus bus;

    @Bean
    public Server restServer() throws IOException {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        endpoint.setAddress("/oauth");
        endpoint.setServiceBeans(Arrays.asList(this.accessTokenService()));
        endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
        endpoint.setProvider(new OAuthJSONProvider());
        final Properties signatureProperties = new Properties();
        signatureProperties.load(this.getClass().getResourceAsStream("/properties/jwt.signature.properties"));
        final Properties encryptionProperties = new Properties();
        encryptionProperties.load(this.getClass().getResourceAsStream("/properties/jwt.encryption.properties"));
        final Map<String, Object> propertiesMap = new HashMap<>(2);
        propertiesMap.put("rs.security.signature.properties", signatureProperties);
        propertiesMap.put("rs.security.encryption.properties", encryptionProperties);
        endpoint.setProperties(propertiesMap);
        return endpoint.create();
    }

    @Bean
    public AccessTokenService accessTokenService() {
        final AccessTokenService accessTokenService = new AccessTokenService();
        accessTokenService.setDataProvider(this.oauthDataProvider());
        final ClientCredentialsGrantHandler clientCredentialsGrantHandler = new ClientCredentialsGrantHandler();
        clientCredentialsGrantHandler.setDataProvider(this.oauthDataProvider());
        accessTokenService.setGrantHandler(clientCredentialsGrantHandler);
        return accessTokenService;
    }

    @Bean
    public OAuthDataProvider oauthDataProvider() {
        final JwtOauthCustomProvider oAuthDataProvider = new JwtOauthCustomProvider();
        oAuthDataProvider.setAccessTokenLifetime(300L);
        oAuthDataProvider.setRecycleRefreshTokens(true);
        oAuthDataProvider.setUseJwtFormatForAccessTokens(true);
        oAuthDataProvider.setEntityManagerFactory(this.entityManagerFactory);
        return oAuthDataProvider;
    }

}
