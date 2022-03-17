package com.example.springbootjavaboilerplate.common.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

@Getter
public class ResponseDto<T> implements Serializable {
    private final T data;

    private ResponseDto(final T data) {
        this.data = data;
    }

    public static <T> ResponseEntity<ResponseDto<T>> of(final T data, final HttpStatus status) {
        return ResponseEntity
                .status(status)
                .body(new ResponseDto<>(data));
    }

    public static <T> ResponseEntity<ResponseDto<T>> success(final T data) {
        return ResponseEntity
                .ok(new ResponseDto<>(data));
    }

    public static void noContent() {
        ResponseEntity.noContent();
    }
}