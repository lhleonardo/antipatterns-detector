package com.lhleonardo.antipatterns.detector.microservices.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhleonardo.antipatterns.detector.microservices.api.dtos.RegisterMicroserviceApiDto;
import com.lhleonardo.antipatterns.detector.microservices.usecases.RegisterMicroserviceUsecase;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/microservices")
public class MicroserviceController {

    private final RegisterMicroserviceUsecase registerMicroserviceUsecase;

    /**
     * Register a new microservice in the system to use in communication
     * relationships.
     */
    @PostMapping
    public void register(@RequestBody RegisterMicroserviceApiDto registerMicroserviceApiDto) {
        this.registerMicroserviceUsecase.execute(
                registerMicroserviceApiDto.getName(),
                registerMicroserviceApiDto.getAddresses(),
                registerMicroserviceApiDto.getMetadata());
    }

}
