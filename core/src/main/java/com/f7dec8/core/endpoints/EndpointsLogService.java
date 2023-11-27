package com.f7dec8.core.endpoints;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.f7dec8.shared.model.EndpointLog;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EndpointsLogService {

    private final EndpointsLogRepository repository;
    
    @Async
    public void logging(EndpointLog endpoint) {
        repository.save(endpoint);
    }
    
}
