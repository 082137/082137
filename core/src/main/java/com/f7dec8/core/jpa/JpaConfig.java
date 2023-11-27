package com.f7dec8.core.jpa;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableJpaAuditing
public class JpaConfig {

    @Bean
    protected AuditorAware<Object> auditorProvider() {
        return new AuditorAwareImpl();
    }

    public class AuditorAwareImpl implements AuditorAware<Object> {

        @Override
        public Optional<Object> getCurrentAuditor() {
            Authentication autentication = SecurityContextHolder.getContext().getAuthentication();
            if (autentication == null || !autentication.isAuthenticated()) {
                return Optional.of("GUEST");
            }
            return Optional.of(autentication.getPrincipal());
        }

    }

}
