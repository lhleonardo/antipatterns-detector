package com.lhleonardo.antipatterns.detector.microservices.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhleonardo.antipatterns.detector.microservices.api.dtos.RegisterCommunicationApiDto;
import com.lhleonardo.antipatterns.detector.microservices.api.dtos.RegisterMicroserviceApiDto;
import com.lhleonardo.antipatterns.detector.microservices.usecases.AddComunicationBetweenMicroserviceUsecase;
import com.lhleonardo.antipatterns.detector.microservices.usecases.RegisterMicroserviceUsecase;
import com.lhleonardo.antipatterns.detector.microservices.usecases.dtos.CommunicationBetweenMicroserviceDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/microservices")
public class MicroserviceController {

    private final RegisterMicroserviceUsecase registerMicroserviceUsecase;
    private final AddComunicationBetweenMicroserviceUsecase addComunicationBetweenMicroserviceUsecase;

    /**
     * Register a new microservice in the system to use in communication
     * relationships.
     * 
     * @param registerMicroserviceApiDto the microservice to be registered.
     */
    @PostMapping
    public void register(@RequestBody RegisterMicroserviceApiDto registerMicroserviceApiDto) {
        this.registerMicroserviceUsecase.execute(
                registerMicroserviceApiDto.getName(),
                registerMicroserviceApiDto.getAlias(),
                registerMicroserviceApiDto.getAddresses(),
                registerMicroserviceApiDto.getMetadata());
    }

    /**
     * Register a new communication between two microservices.
     * 
     * @param registerCommunicationApiDto the communication to be registered.
     */
    @PostMapping("/comunication")
    public void registerNewCommunication(
            @RequestBody RegisterCommunicationApiDto registerCommunicationApiDto) {

        this.addComunicationBetweenMicroserviceUsecase.execute(
                CommunicationBetweenMicroserviceDto.from(registerCommunicationApiDto));
    }

}
