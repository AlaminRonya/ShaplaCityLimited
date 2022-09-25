package com.example.shapla_city_limited.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientInformationController {
    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }
}
