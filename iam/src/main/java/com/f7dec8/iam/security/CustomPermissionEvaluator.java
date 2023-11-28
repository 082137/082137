package com.f7dec8.iam.security;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object target, Object permission) {
        log.debug("#### IAM CustomPermissionEvaluator hasPermission: {}, {}, {}", authentication, target, permission);
        return true;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
            Object permission) {
        log.debug("#### IAM CustomPermissionEvaluator hasPermission: {}, {}, {}, {}", authentication, targetId,
                targetType, permission);
        return true;
    }

    // 아래에 속성별 권한 설정 시작
    
}
