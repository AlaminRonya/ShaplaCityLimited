package com.example.shapla_city_limited.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@ToString
public class RequestClientDto {

    @NotBlank(message = "*must not be blank")
    private String name;

    @NotBlank(message = "*must not be blank")
    private String country;

    @NotBlank(message = "*must not be blank")
    private String bookingDate;

    @NotBlank(message = "*must not be blank")
    private String phoneNumber;

    @NotBlank(message = "*must not be blank")
    private String address;

    @NotBlank(message = "*must not be blank")
    private String buildingNo;

    @NotBlank(message = "*must not be blank")
    private String fileNo;

    @NotBlank(message = "*must not be blank")
    private String flatSize;

    @NotBlank(message = "*must not be blank")
    private String contactMessenger;

    @NotBlank(message = "*must not be blank")
    private String contactWhatsApp;
}
