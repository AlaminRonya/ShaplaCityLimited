package com.example.shapla_city_limited.service;

import com.example.shapla_city_limited.converter.ClientConverter;
import com.example.shapla_city_limited.dto.RequestClientDto;
import com.example.shapla_city_limited.entity.ClientInformation;
import com.example.shapla_city_limited.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientInformationService {
    @Autowired
    private ClientRepository clientRepository;

    public void addClient(RequestClientDto dto){
        final ClientInformation clientInformation = ClientConverter.dtoToPojo(dto);
        clientInformation.setClientID(UUID.randomUUID());
        clientRepository.save(clientInformation);
    }
}
