package com.f7dec8.iam.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("login")
public class LoginController {

    @GetMapping
    public String form(Model model) {
        log.debug("#### model: {}", model);
        return "login.html";
    }
    
}
