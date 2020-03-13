package com.agencyplatform.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class IndexController {
    @GetMapping("/hello")
    public String hello(){
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

}
