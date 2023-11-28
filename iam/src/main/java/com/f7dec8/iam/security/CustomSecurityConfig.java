package com.f7dec8.iam.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.f7dec8.core.config.SecurityConfig;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class CustomSecurityConfig extends SecurityConfig {

    @Bean
    @Override
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return configure(http).build();
    }

    @Override
    protected HttpSecurity configure(HttpSecurity http) throws Exception {
        http = super.configure(http);
        return http
                .formLogin(configurer -> configurer
                        .successHandler(successHandler())
                        .failureHandler(failureHandler()))
                .logout(configurer -> configurer.logoutSuccessUrl("/login"));
    }

    @Bean
    protected AuthenticationSuccessHandler successHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    @Bean
    protected AuthenticationFailureHandler failureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

    @Bean
    protected MethodSecurityExpressionHandler methodSecurityExpressionHandler() {
        MethodSecurityExpressionHandler handler = super.methodSecurityExpressionHandler();
        ((DefaultMethodSecurityExpressionHandler) handler).setPermissionEvaluator(permissionEvaluator());
        return handler;
    }

    @Bean
    protected PermissionEvaluator permissionEvaluator() {
        return new CustomPermissionEvaluator();
    }

}
