package com.agencyplatform.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {
    @GetMapping("/")
    public String hello(){
        return "index";
    }
}
