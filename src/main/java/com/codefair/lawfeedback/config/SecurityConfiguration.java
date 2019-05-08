package com.codefair.lawfeedback.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/users/**").permitAll()
                .antMatchers("/jobs").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/articles").permitAll()
                .antMatchers("/articles/**").permitAll().anyRequest()
                .authenticated().and().csrf().disable();
    }
}
