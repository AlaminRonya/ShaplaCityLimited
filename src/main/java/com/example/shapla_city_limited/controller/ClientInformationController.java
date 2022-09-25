package com.example.shapla_city_limited.controller;

import com.example.shapla_city_limited.dto.RequestClientDto;
import com.example.shapla_city_limited.dto.ResponseClientDto;
import com.example.shapla_city_limited.entity.ClientInformation;
import com.example.shapla_city_limited.repository.ClientRepository;
import com.example.shapla_city_limited.service.ClientInformationService;
import com.example.shapla_city_limited.validation.ClientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Controller
public class ClientInformationController {
    @Autowired
    private ClientInformationService clientInformationService;

    @GetMapping("/{id}")
    public String homePage(@PathVariable("id") String id){
        System.out.println(id);
        return "";
    }


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
        ClientValidator.ValidationResult validationResult = ClientValidator.isPhoneNumberValid()
                .and(ClientValidator.isWhatsAppNumberValid())
                .apply(dto);
        if (validationResult != ClientValidator.ValidationResult.SUCCESS){
            System.out.println(validationResult.name());
            return "addClient";
        }
        clientInformationService.addClient(dto);
        return "redirect:/client/add";
    }

    @GetMapping("/client/all")
    public String getAll(Model model){
        final List<ResponseClientDto> allClient = clientInformationService.getAllClient();
        if (allClient != null){
            model.addAttribute("responseClientDto", allClient);
        }
        return "clientShow";
    }

    @GetMapping("/client/active/{uuid}")
    public String activeAndDeactive(@PathVariable("uuid") String uuid){
        final UUID uuid1 = UUID.fromString(uuid);
        clientInformationService.activeChange(uuid1);
        return "redirect:/client/all";
    }


}
