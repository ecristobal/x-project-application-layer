package com.tecnopyme.application.layer.security.authentication.manager.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
@EnableAuthorizationServer
public class SpringSecurityBeanConfiguration extends AuthorizationServerConfigurerAdapter {

    @Value("${token.validity.seconds}")
    private int tokenValidity;

    @Value("${keystore.password}")
    private char[] keystorePassword;

    @Bean
    public AuthorizationServerTokenServices tokenServices(final TokenStore tokenStore) {
        final DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore);
        return tokenServices;
    }

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

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // TODO When data store is ready, change in-memory client data storage by the proper one
        // @formatter:off
        clients.inMemory()
            .withClient("test")
            .authorizedGrantTypes("client_credentials")
            .authorities("ROLE_CLIENT")
            .scopes("read", "trust")
            .redirectUris("http://anywhere?key=value")
            .secret("test");
        // @formatter:on
    }

}