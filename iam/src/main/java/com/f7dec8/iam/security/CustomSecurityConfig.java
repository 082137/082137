package com.f7dec8.iam.security;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;

import com.f7dec8.core.config.SecurityConfig;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
//        http = super.configure(http
//                .authorizeHttpRequests(request -> request
//                .requestMatchers(AntPathRequestMatcher.antMatcher("/login"))
//                .permitAll()));
        
        // 로그인 성공 => Origin
        // 로그인 실패 => Referer
        // 로그아웃 성공 => 
        
        return super.configure(http)
                .addFilterBefore(new DefaultLoginPageGeneratingFilter() {
                    @Override
                    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                            throws IOException, ServletException {
                        log.debug("#### doFilterdoFilterdoFilterdoFilter");
                        super.doFilter(request, response, chain);
                    }
                    
                    
                }, DefaultLoginPageGeneratingFilter.class)
                .formLogin(configurer -> configurer
                        .loginPage("/login")
//                        .loginProcessingUrl("/login")
                        .successHandler(successHandler())
//                        .failureHandler(failureHandler())
                        )
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
