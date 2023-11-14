package com.f7dec8.playground.web;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("version")
public class AuthenticationController {

    @GetMapping
    public ResponseEntity<String> test() {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        log.debug("#### authentication: {}", authentication);
        log.debug("#### authentication.isAuthenticated: {}", authentication.isAuthenticated());
        
        return ResponseEntity.ok("");
    }
    
}
