package com.example.shapla_city_limited.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
@Data
@Entity
@Table(name = "client_tbl")
public class ClientInformation implements Serializable {
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    @Setter(AccessLevel.NONE)
    private Long id;
    private UUID clientID;
    private String name;
    private String country;
    private String bookingDate;
    private String phoneNumber;
    private String address;
    private String buildingNo;
    private String fileNo;
    private Integer flatSize;
    private String contactMessenger;
    private String contactWhatsApp;
    private Boolean status = false;

}
