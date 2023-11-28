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
    protected AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }

    public static class AuditorAwareImpl implements AuditorAware<String> {

        @Override
        public Optional<String> getCurrentAuditor() {
            Authentication autentication = SecurityContextHolder.getContext().getAuthentication();

            log.debug("#### autentication: {}", autentication);

            if (autentication == null || !autentication.isAuthenticated()) {
                return Optional.of("LOCAL");
            }
            return Optional.of(autentication.getName());
        }

    }

}
