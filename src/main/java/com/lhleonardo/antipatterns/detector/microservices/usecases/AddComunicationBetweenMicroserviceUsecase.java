package com.lhleonardo.antipatterns.detector.microservices.usecases;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.lhleonardo.antipatterns.detector.microservices.errors.MicroserviceErrorsEnum;
import com.lhleonardo.antipatterns.detector.microservices.models.Communication;
import com.lhleonardo.antipatterns.detector.microservices.models.Microservice;
import com.lhleonardo.antipatterns.detector.microservices.repositories.CommunicationRepository;
import com.lhleonardo.antipatterns.detector.microservices.repositories.MicroserviceRepository;
import com.lhleonardo.antipatterns.detector.microservices.usecases.dtos.CommunicationBetweenMicroserviceDto;
import com.lhleonardo.antipatterns.detector.shared.AppException;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AddComunicationBetweenMicroserviceUsecase {

    private final MicroserviceRepository microserviceRepository;
    private final CommunicationRepository communicationRepository;

    @Transactional()
    public void execute(CommunicationBetweenMicroserviceDto dto) {
        Microservice source = this.microserviceRepository
                .findByIdentifier(dto.getSource())
                .orElseThrow(() -> new AppException(MicroserviceErrorsEnum.MICROSERVICE_NOT_FOUND));

        Microservice target = this.microserviceRepository
                .findByIdentifier(dto.getTarget())
                .orElseThrow(() -> new AppException(MicroserviceErrorsEnum.MICROSERVICE_NOT_FOUND));

        Communication communication = new Communication();
        communication.setIdentifier(UUID.randomUUID().toString());
        communication.setSource(source);
        communication.setTarget(target);
        communication.setDurationInMilliseconds(dto.getDurationInMilliseconds());

        this.communicationRepository.save(communication);
    }

}
