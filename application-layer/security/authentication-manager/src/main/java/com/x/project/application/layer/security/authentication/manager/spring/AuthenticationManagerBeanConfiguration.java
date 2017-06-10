package com.x.project.application.layer.security.authentication.manager.spring;

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
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.x.project.application.layer.security.authentication.manager.provider.JwtOauthSpringSecurityProvider;

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

    /**
     * @param bus
     *            CXF {@link Bus} instance
     * @param accessTokenService
     *            CXF {@link AccessTokenService} instance
     * @return CXF {@link Server} instance
     * @throws IOException
     *             in case of problems reading properties files
     */
    @Bean
    public Server restServer(final Bus bus, final AccessTokenService accessTokenService) throws IOException {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        endpoint.setAddress("/oauth");
        endpoint.setServiceBeans(Arrays.asList(accessTokenService));
        endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
        endpoint.setProvider(new OAuthJSONProvider());
        final Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("/properties/jwt.signature.properties"));
        properties.load(this.getClass().getResourceAsStream("/properties/jwt.encryption.properties"));
        final Map<String, Object> propertiesMap = new HashMap<>(properties.size());
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            propertiesMap.put(entry.getKey().toString(), entry.getValue());
        }
        endpoint.setProperties(propertiesMap);
        return endpoint.create();
    }

    /**
     * @param oAuthDataProvider
     *            CXF {@link OAuthDataProvider} instance
     * @return CXF {@link AccessTokenService} instance
     */
    @Bean
    public AccessTokenService accessTokenService(final OAuthDataProvider oAuthDataProvider) {
        final AccessTokenService accessTokenService = new AccessTokenService();
        accessTokenService.setDataProvider(oAuthDataProvider);
        final ClientCredentialsGrantHandler clientCredentialsGrantHandler = new ClientCredentialsGrantHandler();
        clientCredentialsGrantHandler.setDataProvider(oAuthDataProvider);
        accessTokenService.setGrantHandler(clientCredentialsGrantHandler);
        return accessTokenService;
    }

    /**
     * @param entityManagerFactory
     *            JPA {@link EntityManagerFactory} instance
     * @return CXF {@link OAuthDataProvider} instance
     */
    @Bean
    public OAuthDataProvider oauthDataProvider(final EntityManagerFactory entityManagerFactory) {
        final JwtOauthSpringSecurityProvider oAuthDataProvider = new JwtOauthSpringSecurityProvider();
        oAuthDataProvider.setAccessTokenLifetime(300L);
        oAuthDataProvider.setRecycleRefreshTokens(true);
        oAuthDataProvider.setUseJwtFormatForAccessTokens(true);
        return oAuthDataProvider;
    }

}
