package com.lhleonardo.antipatterns.detector.shared;

public class AppException extends RuntimeException {

    private CustomError customError;

    public AppException(CustomError customError) {
        super(customError.getMessage());
        this.customError = customError;
    }

    public CustomError getCustomError() {
        return customError;
    }
}
