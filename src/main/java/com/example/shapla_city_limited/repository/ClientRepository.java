package com.example.shapla_city_limited.repository;

import com.example.shapla_city_limited.entity.ClientInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional(readOnly = true)
public interface ClientRepository extends JpaRepository<ClientInformation, Long> {
    Optional<ClientInformation> findByClientID(UUID uuid);

    @Transactional
    @Modifying
    @Query("UPDATE ClientInformation c " + "SET c.status = ?2    WHERE c.clientID = ?1")
    int activeByUuId(UUID uuid, Boolean status);

    @Transactional
    @Modifying
    @Query("UPDATE ClientInformation c " + "SET c.name = ?2, c.country = ?3, c.bookingDate = ?4, c.phoneNumber = ?5," +
            "c.address = ?6, c.buildingNo = ?7, c.fileNo = ?8, c.flatSize = ?9, c.contactMessenger = ?10," +
            "c.contactWhatsApp = ?11 WHERE c.clientID = ?1")
    int updateClient(UUID uuid, String name, String country, String bookingDate, String phoneNumber,
                     String address, String buildingNo, String fileNo, String fileSize, String messenger,
                     String whatsApp);

}
