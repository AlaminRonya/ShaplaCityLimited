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

    public void update(UUID uuid, RequestClientDto dto) {

        final Optional<ClientInformation> byClientID = clientRepository.findByClientID(uuid);
        if (byClientID.isPresent()){
            dto.setAddress("Dhaka");
            final ClientInformation clientInformation = checkUpdateValue(byClientID.get(), dto);
            clientRepository.updateClient(uuid,clientInformation.getName(),
                    clientInformation.getCountry(), clientInformation.getBookingDate(),
                    clientInformation.getPhoneNumber(), clientInformation.getAddress(),
                    clientInformation.getBuildingNo(),
                    clientInformation.getFileNo(), clientInformation.getFlatSize(),
                    clientInformation.getContactMessenger(),
                    clientInformation.getContactWhatsApp());
        }
    }

    private ClientInformation checkUpdateValue(ClientInformation clientInformation, RequestClientDto dto) {
        if (!dto.getName().equals(clientInformation.getName())) {
            clientInformation.setName(dto.getName());
        }

        if (!dto.getCountry().equals(clientInformation.getCountry())) {
            clientInformation.setCountry(dto.getCountry());
        }
        if (!dto.getBookingDate().equals(clientInformation.getBookingDate())) {
            clientInformation.setBookingDate(dto.getBookingDate());
        }
        if (!dto.getPhoneNumber().equals(clientInformation.getPhoneNumber())) {
            clientInformation.setPhoneNumber(dto.getPhoneNumber());
        }
        if (!dto.getAddress().equals(clientInformation.getAddress())) {
            clientInformation.setAddress(dto.getAddress());
        }
        if (!dto.getBuildingNo().equals(clientInformation.getBuildingNo())) {
            clientInformation.setBuildingNo(dto.getBuildingNo());
        }
        if (!dto.getFileNo().equals(clientInformation.getFileNo())) {
            clientInformation.setFileNo(dto.getFileNo());
        }
        if (!dto.getFlatSize().equals(clientInformation.getFlatSize())) {
            clientInformation.setFlatSize(dto.getFlatSize());
        }
        if (!dto.getContactMessenger().equals(clientInformation.getContactMessenger())) {
            clientInformation.setContactMessenger(dto.getContactMessenger());
        }
        if (!dto.getContactWhatsApp().equals(clientInformation.getContactWhatsApp())) {
            clientInformation.setContactWhatsApp(dto.getContactWhatsApp());
        }
        clientInformation.setCountry("UK");
        return clientInformation;
    }

    public ResponseClientDto getClientByUUID(UUID uuid){
        final Optional<ClientInformation> byClientID = clientRepository.findByClientID(uuid);
        return byClientID.map(ClientConverter::pojoToDto).orElse(null);
    }
}
