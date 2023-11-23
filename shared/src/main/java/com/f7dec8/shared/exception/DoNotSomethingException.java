package com.f7dec8.shared.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class DoNotSomethingException extends RuntimeException {

    private static final long serialVersionUID = -6988727589259148693L;

    private final HttpHeaders headers = new HttpHeaders();
    private final HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
    
    public DoNotSomethingException(String message) {
        super(message);
    }

}
