package com.ru.br.wishlist.preferences.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@Configuration
@EnableJpaAuditing
//@EnableJpaAuditing
class BeanConfig {
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder();
    }

//    @Bean
//    fun auditorProvider(): AuditorAware<AuditableUser?>? {
//        return AuditorAwareImpl()
//    }
}