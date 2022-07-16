package com.gdsc.cookieparking.cookieparking.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    /* 400 BAD_REQUEST */
    INVALID_PARAM(HttpStatus.BAD_REQUEST, "유효하지 않은 파라미터입니다."),
    MISSING_PARAM(HttpStatus.BAD_REQUEST, "필수 파라미터가 누락되었습니다."),

    /* 401 */
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "인증되지 않은 사용자입니다."),
    NOT_EXISTS_USER(HttpStatus.UNAUTHORIZED, "존재하지 않는 사용자입니다."),

    /* 5xx INTER_SERVER_ERROR */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error")    ;


    private final HttpStatus httpStatus;
    private final String message;
}