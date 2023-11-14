package com.f7dec8.core.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableJpaAuditing
public class JpaConfig {

    @Bean
    AuditorAware<Object> auditorProvider() {
        return new AuditorAwareImpl();
    }

    public class AuditorAwareImpl implements AuditorAware<Object> {

        @Override
        public Optional<Object> getCurrentAuditor() {

            log.debug("#### getCurrentAuditor");

            Authentication autentication = SecurityContextHolder.getContext().getAuthentication();
            if (autentication == null || !autentication.isAuthenticated()) {
                return Optional.of("A");
            }

            return Optional.of(autentication.getPrincipal());
        }

    }

}
