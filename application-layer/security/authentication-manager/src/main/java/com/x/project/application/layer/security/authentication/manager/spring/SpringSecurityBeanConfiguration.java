package com.x.project.application.layer.security.authentication.manager.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
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
@EnableWebSecurity
public class SpringSecurityBeanConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${token.validity.seconds}")
    private int tokenValidity;

    @Value("${keystore.password}")
    private char[] keystorePassword;

    @Bean
    public TokenStore tokenStore(final JwtAccessTokenConverter accessTokenConverter) {
        return new JwtTokenStore(accessTokenConverter);
    }

    @Bean
    public TokenStoreUserApprovalHandler userApprovalHandler(final TokenStore tokenStore,
            final ClientDetailsService clientDetailsService) {
        final TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
        handler.setTokenStore(tokenStore);
        handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
        handler.setClientDetailsService(clientDetailsService);
        return handler;
    }

    @Bean
    public ApprovalStore approvalStore(TokenStore tokenStore) {
        TokenApprovalStore store = new TokenApprovalStore();
        store.setTokenStore(tokenStore);
        return store;
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
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("esteban").password("e1234").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.csrf().disable().anonymous().disable().authorizeRequests().antMatchers("/oauth/token").permitAll();
    }

}
