package com.f7dec8.core.jpa;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaConfig {

//    @Bean
//    protected AuditorAware<String> auditorAware() {
//        return new AuditorAwareImpl();
//    }

}
