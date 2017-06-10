package com.x.project.application.layer.security.authentication.manager.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

/**
 * Spring bean configuration class.
 * 
 * @author Esteban Cristóbal
 */
@Configuration
public class SpringSecurityBeanConfiguration {

    @Value("${token.validity.seconds}")
    private int tokenValidity;

    @Value("${keystore.password")
    private char[] keystorePassword;

    @Bean
    public TokenStore tokenStore(final JwtAccessTokenConverter accessTokenConverter) {
        return new JwtTokenStore(accessTokenConverter);
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        final KeyStoreKeyFactory keyFactory = new KeyStoreKeyFactory(new ClassPathResource("/key/keystore.jks"),
                this.keystorePassword);
        converter.setKeyPair(keyFactory.getKeyPair("ecrert"));
        return converter;
    }

    @Bean
    public AuthorizationServerTokenServices tokenServices(final TokenStore tokenStore,
            final AuthenticationManager authenticationManager, final ClientDetailsService clientDetailsService) {
        final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore);
        defaultTokenServices.setSupportRefreshToken(true);
        defaultTokenServices.setRefreshTokenValiditySeconds(this.tokenValidity);
        defaultTokenServices.setAuthenticationManager(authenticationManager);
        defaultTokenServices.setClientDetailsService(clientDetailsService);
        return defaultTokenServices;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        // TODO Implement authentication manager
        return null;
    }

    @Bean
    public ClientDetailsService clientDetailsService() {
        // Implement client details service
        return null;
    }

}
