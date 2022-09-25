package com.example.shapla_city_limited.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@ToString
public class ResponseClientDto {

    private Long id;
    private UUID clientID;
    private String name;
    private String country;
    private String bookingDate;
    private String phoneNumber;
    private String address;
    private String buildingNo;
    private String fileNo;
    private String flatSize;
    private String contactMessenger;
    private String contactWhatsApp;
    private Boolean status;
}
