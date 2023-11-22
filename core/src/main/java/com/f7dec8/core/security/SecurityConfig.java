package com.f7dec8.core.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
//@EnableRedisHttpSession
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationSuccessHandler successHandler;
    private final AuthenticationFailureHandler failureHandler;
    
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin(configurer -> configurer
                        .successHandler(successHandler)
                        .failureHandler(failureHandler))
                .headers(configurer -> configurer
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
                        .contentSecurityPolicy(policyConfig -> policyConfig
                                .policyDirectives("script-src 'self'; "
                                        + "img-src 'self'; "
                                        + "font-src 'self' data:; "
//                                        + "default-src 'self'; "
                                        + "frame-src 'self'")))
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .build();
    }

    @Bean
    protected SecurityContextRepository securityContextRepository() {
        return new HttpSessionSecurityContextRepository();
    }

    // UserDetailsService 재정의
    // User 사용
    // SavedRequestAwareAuthenticationSuccessHandler 로그인 성공 핸들러

    @Bean
    protected WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
    
    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("1q2w3e4r#"));
    }
    
//    @Bean
//    protected AuthenticationSuccessHandler successHandler(AuthenticationSuccessHandler handler) {
//        if (handler == null) {
//            return new DefaultAuthenticationSuccessHandler();
//        }
//        return handler;
//    }

}
