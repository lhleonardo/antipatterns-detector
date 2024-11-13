package com.lhleonardo.antipatterns.detector.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lhleonardo.antipatterns.detector.microservices.models.Communication;

@Repository
public interface CommunicationRepository extends JpaRepository<Communication, Long> {

}
