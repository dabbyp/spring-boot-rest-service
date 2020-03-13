package com.agencyplatform.springboot.web.membership;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {
    @GetMapping("/membership/payment_register")
    public String register(){
        return "membership/payment_register";
    }
}
