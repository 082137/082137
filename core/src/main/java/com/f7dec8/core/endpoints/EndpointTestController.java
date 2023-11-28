package com.f7dec8.core.endpoints;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("test/endpoints")
public class EndpointTestController {

    @GetMapping
    @PreAuthorize("hasPermission('a', 'a')")
    public ResponseEntity<Map<String, Object>> endpoints(String a, String b) {
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("a", a);
        responseData.put("b", b);
        
        Authentication autentication = SecurityContextHolder.getContext().getAuthentication();
        
        log.debug("#### EndpointController autentication: {}", autentication.getName());
        
        return ResponseEntity.ok(responseData);
    }

}
