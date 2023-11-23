package com.f7dec8.playground.web;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("file")
public class FileDownloadController {

    @PostMapping
//    @GetMapping
    public ResponseEntity<Resource> download() {
        
        byte[] bytes = "hello".getBytes();
        
        Resource resource = new ByteArrayResource(bytes);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"hello.txt\"");
        
        return ResponseEntity.ok().headers(headers).body(resource);
    }
    
}
