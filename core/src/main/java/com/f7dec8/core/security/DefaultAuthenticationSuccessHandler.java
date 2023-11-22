package com.f7dec8.core.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.f7dec8.shared.properties.AuthenticationSuccessHandlerProperties;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class DefaultAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final AuthenticationSuccessHandlerProperties properties;
    
    @PostConstruct
    public void init() {
        setAlwaysUseDefaultTargetUrl(properties.isAlwaysUseDefaultTargetUrl());
        setDefaultTargetUrl(properties.getDefaultTargetUrl());
        setTargetUrlParameter(properties.getTargetUrlParameter());
        setUseReferer(properties.isUseReferer());
    }
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        log.debug("#### Core DefaultAuthenticationSuccessHandler");
        
        super.onAuthenticationSuccess(request, response, authentication);
    }

}
