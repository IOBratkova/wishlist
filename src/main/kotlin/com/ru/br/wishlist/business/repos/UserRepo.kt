package com.ru.br.wishlist.business.repos

import com.ru.br.wishlist.business.enity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepo : JpaRepository<User, Long> {
    fun findByUserCredentialsId(id: Long) : Optional<User>
}