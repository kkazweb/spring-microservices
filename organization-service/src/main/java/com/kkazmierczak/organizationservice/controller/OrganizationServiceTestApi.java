package com.kkazmierczak.organizationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganizationServiceTestApi {

    @GetMapping("/")
    public String hello(){
        return "This is Organization Service. Hello!";
    }

}
