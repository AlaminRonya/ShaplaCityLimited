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

}
