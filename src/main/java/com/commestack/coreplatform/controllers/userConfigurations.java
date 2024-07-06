package com.commestack.coreplatform.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class userConfigurations {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                        configurer
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form.loginPage("/loginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll());
        return http.build();
    }
}
