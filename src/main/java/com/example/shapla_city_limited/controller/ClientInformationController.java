package com.example.shapla_city_limited.controller;

import com.example.shapla_city_limited.entity.ClientInformation;
import com.example.shapla_city_limited.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Controller
public class ClientInformationController {
    @Autowired
    private ClientRepository clientRepository;
    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }
}
