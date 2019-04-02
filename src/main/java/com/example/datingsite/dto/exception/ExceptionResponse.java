package com.example.datingsite.dto.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ExceptionResponse {

    private LocalDateTime time;
    private String message;
    private String detail;

    public ExceptionResponse(String message, String detail) {
        this.message = message;
        this.detail = detail;
        this.time = LocalDateTime.now();
    }
}
