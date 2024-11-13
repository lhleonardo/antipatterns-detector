package com.lhleonardo.antipatterns.detector.microservices.usecases.dtos;

import com.lhleonardo.antipatterns.detector.microservices.api.dtos.RegisterCommunicationApiDto;

import lombok.Data;

@Data
public class CommunicationBetweenMicroserviceDto {

    private String source;
    private String target;

    private Long durationInMilliseconds;

    public static CommunicationBetweenMicroserviceDto from(RegisterCommunicationApiDto registerCommunicationApiDto) {
        CommunicationBetweenMicroserviceDto dto = new CommunicationBetweenMicroserviceDto();
        dto.setSource(registerCommunicationApiDto.getSource());
        dto.setTarget(registerCommunicationApiDto.getTarget());
        dto.setDurationInMilliseconds(registerCommunicationApiDto.getDurationInMilliseconds());
        return dto;
    }
}
