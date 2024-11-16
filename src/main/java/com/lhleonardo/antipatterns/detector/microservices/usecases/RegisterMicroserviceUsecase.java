package com.lhleonardo.antipatterns.detector.microservices.usecases;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.lhleonardo.antipatterns.detector.microservices.models.Microservice;
import com.lhleonardo.antipatterns.detector.microservices.repositories.MicroserviceRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RegisterMicroserviceUsecase {

    private final MicroserviceRepository microserviceRepository;

    @Transactional
    public void execute(String name, String alias, List<String> addresses, Map<String, String> metadata) {
        Microservice microservice = new Microservice();
        microservice.setName(name);
        microservice.setAddresses(addresses);
        microservice.setMetadata(metadata);
        microservice.setAlias(alias);
        microservice.setIdentifier(UUID.randomUUID().toString());

        this.microserviceRepository.save(microservice);
    }

}
