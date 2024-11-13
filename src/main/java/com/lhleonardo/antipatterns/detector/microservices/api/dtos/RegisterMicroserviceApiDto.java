package com.lhleonardo.antipatterns.detector.microservices.api.dtos;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class RegisterMicroserviceApiDto {

    private String name;
    private List<String> addresses;
    private Map<String, String> metadata;

}
