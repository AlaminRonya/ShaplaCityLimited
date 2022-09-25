package com.example.shapla_city_limited.repository;

import com.example.shapla_city_limited.entity.ClientInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientInformation, Long> {
}
