package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2 customOAuth2;

    @Autowired
    public WebSecurity(CustomOAuth2 customOAuth2) {
        this.customOAuth2 = customOAuth2;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/user/**").permitAll();
        http.headers().frameOptions().disable();
        http.oauth2Login().userInfoEndpoint().userService(customOAuth2);

    }
}
