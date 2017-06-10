package com.x.project.application.layer.security.authentication.manager.spring;

import java.io.IOException;
import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.apache.cxf.rs.security.oauth2.grants.clientcred.ClientCredentialsGrantHandler;
import org.apache.cxf.rs.security.oauth2.provider.OAuthDataProvider;
import org.apache.cxf.rs.security.oauth2.provider.OAuthJSONProvider;
import org.apache.cxf.rs.security.oauth2.services.AccessTokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

import com.x.project.application.layer.security.authentication.manager.provider.JwtOauthSpringSecurityProvider;

/**
 * Spring bean configuration class.
 * 
 * @author Esteban Cristóbal
 */
@Configuration
public class AuthenticationManagerBeanConfiguration {

    @Value("${token.validity.seconds}")
    private int tokenValidity;

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
        final JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        endpoint.setAddress("/authentication");
        endpoint.setServiceBeans(Arrays.asList(accessTokenService));
        endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
        endpoint.setProvider(new OAuthJSONProvider());
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
    public OAuthDataProvider oauthDataProvider(final AuthorizationServerTokenServices tokenServices) {
        final JwtOauthSpringSecurityProvider oAuthDataProvider = new JwtOauthSpringSecurityProvider();
        oAuthDataProvider.setAccessTokenLifetime(this.tokenValidity);
        oAuthDataProvider.setRecycleRefreshTokens(true);
        oAuthDataProvider.setUseJwtFormatForAccessTokens(true);
        oAuthDataProvider.setTokenServices(tokenServices);
        return oAuthDataProvider;
    }

}
