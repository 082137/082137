package com.f7dec8.core.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test/endpoints")
public class EndpointController {

    @GetMapping
//    @PreAuthorize("hasPermission('username', 'f7dec8')")
    public ResponseEntity<Map<String, Object>> endpoints(String a, String b) {
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("a", a);
        responseData.put("b", b);
        return ResponseEntity.ok(responseData);
    }

}
