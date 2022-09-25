package com.example.shapla_city_limited.converter;

import com.example.shapla_city_limited.dto.RequestClientDto;
import com.example.shapla_city_limited.dto.ResponseClientDto;
import com.example.shapla_city_limited.entity.ClientInformation;

import java.util.List;

public class ClientConverter {
    public static ClientInformation dtoToPojo(RequestClientDto dto){
        ClientInformation clientInformation = new ClientInformation();
        clientInformation.setName(dto.getName());
        clientInformation.setCountry(dto.getCountry());
        clientInformation.setBookingDate(dto.getBookingDate());
        clientInformation.setPhoneNumber(dto.getPhoneNumber());
        clientInformation.setAddress(dto.getAddress());
        clientInformation.setBuildingNo(dto.getBuildingNo());
        clientInformation.setFileNo(dto.getFileNo());
        clientInformation.setFlatSize(dto.getFlatSize());
        clientInformation.setContactMessenger(dto.getContactMessenger());
        clientInformation.setContactWhatsApp(dto.getContactWhatsApp());

        return clientInformation;
    }

    public static ResponseClientDto pojoToDto(ClientInformation clientInformation){
        ResponseClientDto responseClientDto = new ResponseClientDto();
        responseClientDto.setId(clientInformation.getId());
        responseClientDto.setClientID(clientInformation.getClientID().toString());
        responseClientDto.setName(clientInformation.getName());
        responseClientDto.setCountry(clientInformation.getCountry());
        responseClientDto.setBookingDate(clientInformation.getBookingDate());
        responseClientDto.setPhoneNumber(clientInformation.getPhoneNumber());
        responseClientDto.setAddress(clientInformation.getAddress());
        responseClientDto.setBuildingNo(clientInformation.getBuildingNo());
        responseClientDto.setFileNo(clientInformation.getFileNo());
        responseClientDto.setFlatSize(clientInformation.getFlatSize());
        responseClientDto.setContactMessenger(clientInformation.getContactMessenger());
        responseClientDto.setContactWhatsApp(clientInformation.getContactWhatsApp());
        if (!clientInformation.getStatus()){
            responseClientDto.setStatus("Deactive");
        }else {
            responseClientDto.setStatus("Active");
        }

        return responseClientDto;
    }

    public static List<ResponseClientDto> getAllClient(List<ClientInformation> clientInformations){
        return clientInformations.stream().map(ClientConverter::pojoToDto).toList();
    }
}
