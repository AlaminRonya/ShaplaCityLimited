package com.example.shapla_city_limited.controller;

import com.example.shapla_city_limited.dto.RequestClientDto;
import com.example.shapla_city_limited.entity.ClientInformation;
import com.example.shapla_city_limited.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

@Controller
public class ClientInformationController {


    @GetMapping("/client/add")
    public String getAddClientPage(@ModelAttribute("requestClientDto")RequestClientDto dto){
        return "addClient";
    }

    @PostMapping("/client/add")
    public String addClient(@Valid  @ModelAttribute("requestClientDto")RequestClientDto dto, BindingResult result) throws ParseException {
        System.out.println("dto: "+dto);



        if (result.hasErrors()){

            System.out.println("=============Error==============");
            return "addClient";
        }
        return "redirect:/client/add";
    }


}
