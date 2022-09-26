package com.example.shapla_city_limited.controller;


import com.example.shapla_city_limited.dto.RequestClientDto;
import com.example.shapla_city_limited.dto.ResponseClientDto;
import com.example.shapla_city_limited.service.ClientInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientInformationRestController {
    @Autowired
    private ClientInformationService clientInformationService;


    @PostMapping("/add")
    public void add(@RequestBody RequestClientDto dto){
        clientInformationService.addClient(dto);
    }

    @GetMapping("/all")
    public List<ResponseClientDto> getAll(){
        return clientInformationService.getAllClient();
    }





}
