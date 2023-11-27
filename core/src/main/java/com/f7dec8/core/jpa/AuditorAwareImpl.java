package com.f7dec8.core.jpa;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//        HttpSession session = request.getSession(false);
//        log.debug("#### session: {}", session);
        
        Authentication autentication = SecurityContextHolder.getContext().getAuthentication();

        log.debug("#### autentication: {}", autentication);

        if (autentication == null || !autentication.isAuthenticated()) {
            return Optional.of("LOCAL");
        }
        return Optional.of(autentication.getName());
    }

}
