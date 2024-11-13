package com.lhleonardo.antipatterns.detector.shared;

import org.springframework.http.HttpStatus;

public interface CustomError {
    String getCode();

    String getMessage();

    HttpStatus getStatus();
}
