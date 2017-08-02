package com.x.project.application.layer.security.token.validator;

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
        http.csrf().and().authorizeRequests().antMatchers("/*").authenticated();
    }

}
