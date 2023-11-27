package com.f7dec8.core.security;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
public class DefaultPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        // TODO Auto-generated method stub
        log.debug("#### DefaultPermissionEvaluator hasPermission1: {}, {}, {}", authentication, targetDomainObject,
                permission);
        return true;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
            Object permission) {
        // TODO Auto-generated method stub
        log.debug("#### DefaultPermissionEvaluator hasPermission2: {}, {}, {}, {}", authentication, targetId,
                targetType, permission);
        return true;
    }

}
