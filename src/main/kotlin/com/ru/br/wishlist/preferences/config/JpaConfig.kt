package com.ru.br.wishlist.preferences.config

import org.springframework.context.annotation.Bean
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.security.core.context.SecurityContextHolder
import java.util.*

@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
class JpaConfig {
    @Bean
    fun auditorProvider(): AuditorAware<String> {
        return AuditorAware { Optional.of(SecurityContextHolder.getContext().authentication.name) }
    }
}