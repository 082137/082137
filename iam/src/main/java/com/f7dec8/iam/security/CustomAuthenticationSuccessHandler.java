package com.f7dec8.iam.security;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    public CustomAuthenticationSuccessHandler() {
        super();
//        setUseReferer(true);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        log.debug("#### IAM DefaultAuthenticationSuccessHandler: {}", authentication);
        
        log.debug("#### IAM Authentication success handler Referer: {}", request.getHeader(HttpHeaders.REFERER));

        String uri = request.getRequestURI();
        int pathParamIndex = uri.indexOf(';');
        if (pathParamIndex > 0) {
            uri = uri.substring(0, pathParamIndex);
        }
        if (request.getQueryString() != null) {
            uri += "?" + request.getQueryString();
        }
        
        log.debug("#### IAM uri: {}", uri);
        
        if ("".equals(request.getContextPath())) {
            log.debug("#### IAM uri.equals(\"/login\"): {}", uri.equals("/login"));
        }
        log.debug("#### IAM uri.equals(request.getContextPath() + \"/login\"): {}", uri.equals(request.getContextPath() + "/login"));
        
        super.onAuthenticationSuccess(request, response, authentication);
    }

}
