package com.f7dec8.playground.web;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("version")
public class AuthenticationController {

    private final RequestMappingHandlerMapping mapping;
    
    @GetMapping
    public ResponseEntity<String> test() {
        
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : map.entrySet()) {
            RequestMappingInfo info = entry.getKey();
            HandlerMethod method = entry.getValue();
            log.debug("#### method: {}", info.getPatternValues(), method.getMethod());
        }
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        log.debug("#### authentication: {}", authentication);
        log.debug("#### authentication.anonymous: {}", authentication instanceof AnonymousAuthenticationToken);
        log.debug("#### authentication.principal: {}", authentication.getPrincipal());
        log.debug("#### authentication.isAuthenticated: {}", authentication.isAuthenticated());
        
        return ResponseEntity.ok("");
    }
    
}
