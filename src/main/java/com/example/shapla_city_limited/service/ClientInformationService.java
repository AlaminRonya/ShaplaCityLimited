package com.example.shapla_city_limited.service;

import com.example.shapla_city_limited.converter.ClientConverter;
import com.example.shapla_city_limited.dto.RequestClientDto;
import com.example.shapla_city_limited.dto.ResponseClientDto;
import com.example.shapla_city_limited.entity.ClientInformation;
import com.example.shapla_city_limited.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public List<ResponseClientDto> getAllClient(){
        final List<ClientInformation> all = clientRepository.findAll();
        if (all.isEmpty()){
            return null;
        }
        return ClientConverter.getAllClient(all);
    }

    public void activeChange(UUID uuid1) {
        final Optional<ClientInformation> byClientID = clientRepository.findByClientID(uuid1);
        if (byClientID.isPresent()){
//            final ResponseClientDto responseClientDto = ClientConverter.pojoToDto(byClientID.get());
//            System.out.println(responseClientDto);
            final ClientInformation clientInformation = byClientID.get();
            clientRepository.activeByUuId(uuid1, !clientInformation.getStatus());
        }
    }

    public void delete(UUID uuid1) {
        final Optional<ClientInformation> byClientID = clientRepository.findByClientID(uuid1);
        if (byClientID.isPresent()){
            final ClientInformation clientInformation = byClientID.get();
            clientRepository.deleteById(clientInformation.getId());
        }
    }
}
