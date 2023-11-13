package com.f7dec8.core.config;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.cors.CorsConfiguration;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ApplicationSecurityConfig {

//    private final CorsFilter corsFilter;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.debug("#### hi filter chain debug");
        log.info("#### hi filter chain info");
        return http
                .csrf(AbstractHttpConfigurer::disable)
//                .cors(cors -> {
//                    CorsConfiguration source = new CorsConfiguration();
//                    source.setAllowedOrigins(Collections.singletonList("*"));
//                    source.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//                    source.setAllowedHeaders(List.of("*"));
//                    cors.configurationSource(configurationSource());
//                })
//                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.))
                .securityContext(context -> context.securityContextRepository(securityContextRepository()))
                .authorizeHttpRequests(request -> request.requestMatchers("/version").permitAll())
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .build();
    }
    
    private CorsConfiguration configurationSource(HttpServletRequest request) {
        CorsConfiguration source = new CorsConfiguration();
        source.setAllowedOrigins(Collections.singletonList("*"));
        source.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        source.setAllowedHeaders(List.of("*"));
        return source;
    }
    
    @Bean
    HttpSessionSecurityContextRepository securityContextRepository() {
        return new HttpSessionSecurityContextRepository();
    }

}
