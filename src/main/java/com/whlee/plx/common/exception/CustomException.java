package com.whlee.plx.common.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{
    private String codeName;
    private ErrorCode errorCode;
    private HttpStatus httpStatus;
    private String message;

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public CustomException(String codeName, HttpStatus httpStatus, String message) {
        this.codeName = codeName;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public CustomException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
