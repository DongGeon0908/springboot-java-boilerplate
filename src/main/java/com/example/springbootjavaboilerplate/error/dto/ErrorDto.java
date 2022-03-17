package com.example.springbootjavaboilerplate.error.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class ErrorDto implements Serializable {
    private final ErrorMessage errorMessage;
    private final String reason;

    public ErrorDto(ErrorMessage errorMessage, String reason) {
        this.errorMessage = errorMessage;
        this.reason = reason;
    }
}