package com.example.star.incident;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IncidentBusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse<?>> handleIncidentBusinessException(IncidentBusinessException ex) {
        return new ResponseEntity<>(new ApiResponse<>(ex.getCode(), false, ex.getMessage(), null), HttpStatus.OK);
    }
}