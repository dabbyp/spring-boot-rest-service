package com.agencyplatform.springboot.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties implements ApplicationRunner {
//    @Value("${key}")
//    private String key;
//
//    public String getKey(){
//        return key;
//    }
//
//    public static String strKey;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        System.out.println("================= key : " + key);
//        strKey = key;
    }
}
