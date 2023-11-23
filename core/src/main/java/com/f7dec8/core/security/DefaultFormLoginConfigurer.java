package com.f7dec8.core.security;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.RequiredArgsConstructor;

//@Configuration
@RequiredArgsConstructor
public class DefaultFormLoginConfigurer {

    private final AuthenticationSuccessHandler successHandler;
    private final AuthenticationFailureHandler failureHandler;

    public Customizer<FormLoginConfigurer<HttpSecurity>> toConfigurer() {
        return configurer -> configurer
                .successHandler(successHandler)
                .failureHandler(failureHandler);
    }

}
