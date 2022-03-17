package com.example.springbootjavaboilerplate.error;

import com.example.springbootjavaboilerplate.error.dto.ErrorDto;
import com.example.springbootjavaboilerplate.error.dto.ErrorMessage;
import com.example.springbootjavaboilerplate.error.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorDto> handleBusinessException(
            final BusinessException e) {
        log.error("[ERROR] Exception -> {}", e.getCause());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(ErrorMessage.CONFLICT_ERROR, e.getCause().toString()));
    }
}