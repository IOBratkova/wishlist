package com.ru.br.wishlist.business.service.user

import com.ru.br.wishlist.business.enity.UserCredentials
import org.springframework.stereotype.Service

@Service
interface UserCredentialsService {
    fun findById(id: Long) : UserCredentials
    fun findByUsername(username: String) : UserCredentials
    fun findByEmail(email: String) : UserCredentials
    fun findUserByCredentials(email: String?, username: String?, password: String?) : UserCredentials

    fun existByUsername(username: String) : Boolean
    fun existByEmail(email: String) : Boolean

    fun save(userCredentials: UserCredentials) : UserCredentials
}