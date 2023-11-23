package com.f7dec8.core.security;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.f7dec8.shared.properties.AuthenticationFailureHandlerProperties;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class DefaultAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private final AuthenticationFailureHandlerProperties properties;
    
    @PostConstruct
    public void init() {
        setUseForward(properties.isForwardToDestination());
        setAllowSessionCreation(properties.isAllowSessionCreation());
        setDefaultFailureUrl(properties.getDefaultFailureUrl());
    }
    
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
        
        log.debug("#### authentication failure exception: {}", exception);
        
        saveException(request, exception);
        
        String referer = request.getHeader(HttpHeaders.REFERER);
        
        RedirectStrategy strategy = getRedirectStrategy();
        strategy.sendRedirect(request, response, referer + "?error");
//        request.getRequestDispatcher("/login?error").forward(request, response);
        
//        super.onAuthenticationFailure(request, response, exception);
    }

}
