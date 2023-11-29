package com.f7dec8.iam.security;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Controller
//@RequestMapping("login")
public class LoginController {

//    @GetMapping
//    public String index(HttpServletRequest request, Model model) {
//        log.debug("#### model: {}", model);
//        String query = request.getQueryString();
//        log.debug("#### query: {}", query);
//        if (StringUtils.isNotBlank(query)) {
//            return "redirect:login?" + query;
//        }
//        return "redirect:login";
//    }
    
    @GetMapping("login")
    public String form(Model model) {
        log.debug("#### model: {}", model);
        model.addAttribute("url", "/login");
        return "login";
    }
    
}
