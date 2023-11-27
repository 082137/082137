package com.f7dec8.core.endpoints;

import java.util.Arrays;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.f7dec8.shared.model.EndpointLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class EndpointsLogAspect {
    
    private static final ObjectMapper mapper = JsonMapper
            .builder()
            .build();
    
    private final EndpointsLogService service;
    
    @Around("execution(* com.f7dec8..*Controller.*(..))") 
    public void logging(ProceedingJoinPoint joinpoint) {
        
        HttpServletRequest request = getRequest();
        
        long start = System.nanoTime();
        
        String signature = getSignature(joinpoint);
        RequestMethod method = getMethod(request);
        String path = getPath(request);
        String parameters = getParameters(joinpoint);
        String responseBody = getResponseBody(joinpoint);
        int responseStatusCode = getResponseStatusCode(joinpoint);
        String clientIpAddress = getClientIpAddress(request);
        
        long end = System.nanoTime();
        double executionTimeMillis = getExecutionTimeMillis(start, end);
        
        EndpointLog log = EndpointLog.builder()
                .signature(signature)
                .method(method)
                .path(path)
                .parameters(parameters)
                .responseBody(responseBody)
                .responseStatusCode(responseStatusCode)
                .executionTimeMillis(executionTimeMillis)
                .clientIpAddress(clientIpAddress)
                .build();
        
        service.logging(log);
    }
    
    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }
    
    private String getSignature(ProceedingJoinPoint joinpoint) {
        return joinpoint.getSignature().toShortString();
    }
    
    private RequestMethod getMethod(HttpServletRequest request) {
        return RequestMethod.resolve(request.getMethod());
    }
    
    private String getPath(HttpServletRequest request) {
        return request.getRequestURI();
    }

    private String getParameters(ProceedingJoinPoint joinpoint) {
        Object[] args = joinpoint.getArgs();
        try {
            return mapper.writeValueAsString(args);
        } catch (JsonProcessingException e) {
            return Arrays.toString(args);
        }
    }

    private String getResponseBody(ProceedingJoinPoint joinpoint) {
        try {
            Object responseData = joinpoint.proceed();
            if (responseData instanceof ResponseEntity<?> response) {
                return mapper.writeValueAsString(response.getBody());
            }
            return Objects.toString(responseData);
        } catch (Throwable e) {
            return e.getMessage();
        }
    }

    private int getResponseStatusCode(ProceedingJoinPoint joinpoint) {
        HttpStatusCode responseStatusCode = HttpStatus.OK;
        try {
            Object responseData = joinpoint.proceed();
            if (responseData instanceof ResponseEntity<?> response) {
                responseStatusCode = response.getStatusCode();
            }
        } catch (Throwable e) {
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return responseStatusCode.value();
    }
    
    private double getExecutionTimeMillis(long start, long end) {
        return (end - start) / 1e6; 
    }

    private String getClientIpAddress(HttpServletRequest request) {
        String clientIP = request.getRemoteAddr();
        String forwardedFor = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotBlank(forwardedFor)) {
            clientIP = forwardedFor.split(",")[0].trim();
        }
        return clientIP;
    }
    
}
