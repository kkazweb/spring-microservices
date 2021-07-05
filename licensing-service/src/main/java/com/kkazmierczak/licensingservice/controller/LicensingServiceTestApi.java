package com.kkazmierczak.licensingservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LicensingServiceTestApi {

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @Value("${user.role}")
    private String role;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String czycreatedrop;

    @GetMapping(value = "/hello/{username}")
    public String hello(@PathVariable("username") String username){
        return String.format("Hello %s! You are a(an) %s.\n Database url is: %s, and current setting is %s", username, role, url, czycreatedrop);
    }

    @GetMapping("/")
    public String hello(){
        return "This is Licensing Service. Hello! My instance-id is: " + instanceId;
    }

}
