package com.lhleonardo.antipatterns.detector.microservices.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lhleonardo.antipatterns.detector.microservices.models.Microservice;

@Repository
public interface MicroserviceRepository extends JpaRepository<Microservice, Integer> {

    Optional<Microservice> findByIdentifier(String identifier);
}
