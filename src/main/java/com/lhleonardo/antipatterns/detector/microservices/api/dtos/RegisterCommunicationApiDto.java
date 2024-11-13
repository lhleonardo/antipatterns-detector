package com.lhleonardo.antipatterns.detector.microservices.api.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterCommunicationApiDto {

    @NotEmpty(message = "The source microservice identifier is required")
    @Schema(description = "The source microservice identifier", example = "microservice-2")
    private String source;

    @NotEmpty(message = "The target microservice identifier is required")
    @Schema(description = "The source microservice identifier", example = "microservice-2")
    private String target;

    @NotNull(message = "The communication duration in milliseconds is required")
    @Min(value = 0, message = "The communication duration in milliseconds must be greater than or equal to 0")
    @Schema(description = "The communication duration in milliseconds", example = "100")
    private Long durationInMilliseconds;

}
