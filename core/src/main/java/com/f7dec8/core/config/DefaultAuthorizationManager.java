package com.f7dec8.core.config;

import java.util.function.Supplier;

import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultAuthorizationManager implements AuthorizationManager<Authentication> {

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, Authentication object) {
        log.debug("#### DefaultAuthorizationManager");
        return new DefaultAuthorizationDecision(true);
    }

    public class DefaultAuthorizationDecision extends AuthorizationDecision {

        public DefaultAuthorizationDecision(boolean granted) {
            super(granted);
        }

    }

}
