package com.f7dec8.playground.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f7dec8.shared.exception.DoSomethingException;

@RestController
@RequestMapping("test/occured")
public class OccuredExceptionController {

    @GetMapping
    public ResponseEntity<String> occured(boolean occured) {

        if (occured) {
            throw new DoSomethingException("asdf");
        }

        return ResponseEntity.ok("OK");
    }

}
