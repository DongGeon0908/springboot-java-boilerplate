package com.example.springbootjavaboilerplate.error.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {
    /**
     * CONFLICT ERROR RESPONSE MESSAGE
     **/
    CONFLICT_ERROR("E-C-0001", "예기치 못한 에러가 발생했습니다.");

    private final String code;
    private final String detail;

}
