package com.example.star.incident;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private int code;
    private boolean success;
    private String message;
    private T data;

    public ApiResponse(int code, boolean success, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}