package com.f7dec8.core.advice;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.f7dec8.shared.exception.DoSomethingException;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalRestControllerAdvice extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @PostConstruct
    public void init() {
        setMessageSource(messageSource);
    }

    @ExceptionHandler({ DoSomethingException.class })
    public final ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) throws Exception {
        if (ex instanceof DoSomethingException subEx) {
            return handleDoSomethingException(subEx, subEx.getHeaders(), subEx.getStatusCode(), request);
        }
        throw ex;
    }

    // XXX Sample
    protected ResponseEntity<Object> handleDoSomethingException(DoSomethingException ex, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
        String body = "Do Something";
        return handleExceptionInternal(ex, body, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
            HttpStatusCode statusCode, WebRequest request) {
        log.debug("#### Core handle exception internal");
        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }

}
