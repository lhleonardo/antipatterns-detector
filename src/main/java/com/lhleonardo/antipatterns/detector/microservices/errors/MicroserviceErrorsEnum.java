package com.lhleonardo.antipatterns.detector.microservices.errors;

import org.springframework.http.HttpStatus;

import com.lhleonardo.antipatterns.detector.shared.CustomError;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MicroserviceErrorsEnum implements CustomError {

    MICROSERVICE_NOT_FOUND("MICROSERVICE_NOT_FOUND", "Microservice not found", HttpStatus.NOT_FOUND),
    ;

    private final String code;
    private final String message;
    private final HttpStatus status;

}
