package com.f7dec8.core.endpoints;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f7dec8.shared.model.EndpointLog;

@Repository
public interface EndpointsLogRepository extends JpaRepository<EndpointLog, Long> {

}
