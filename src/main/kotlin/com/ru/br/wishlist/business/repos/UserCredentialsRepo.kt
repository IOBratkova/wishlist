package com.ru.br.wishlist.business.repos

import com.ru.br.wishlist.business.enity.UserCredentials
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserCredentialsRepo : JpaRepository<UserCredentials, Long> {
    fun findFirstByUsername(username: String) : Optional<UserCredentials>
    fun findFirstByEmail(email: String) : Optional<UserCredentials>
    fun existsByUsername(username: String) : Boolean
    fun existsByEmail(email: String) : Boolean
}