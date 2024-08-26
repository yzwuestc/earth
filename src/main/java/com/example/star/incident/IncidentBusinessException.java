package com.example.star.incident;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class IncidentBusinessException extends RuntimeException {
    private int code;
    private String message;

    public IncidentBusinessException(String message) {
        super(message);
        this.code = HttpStatus.OK.value();
        this.message = message;
    }
}