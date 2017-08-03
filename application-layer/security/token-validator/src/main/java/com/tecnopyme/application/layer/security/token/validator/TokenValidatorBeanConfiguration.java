package com.tecnopyme.application.layer.security.token.validator;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class TokenValidatorBeanConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO When data store is ready, change in-memory authentication by the proper one
        // @formatter:off
        auth.inMemoryAuthentication()
            .withUser("test")
            .password("test");
        // @formatter:on
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.csrf()
            // Enable access to Swagger definitions without being authenticated
            .and()
                .authorizeRequests().antMatchers("/**/swagger.*").permitAll()
            .and()
                .authorizeRequests().antMatchers("/api-docs?/url=/swagger.json").permitAll()
            .and()
                .authorizeRequests().antMatchers("/").permitAll()
            // Restrict access only to REST services
            .and()
                .authorizeRequests().antMatchers("/*").authenticated();
        // @formatter:on
    }

}
