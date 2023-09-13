package com.ru.br.wishlist.business.service.user

import com.ru.br.wishlist.business.enity.User
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun findById(id: Long) : User
    fun findByUserCredentialId(id: Long) : User
    fun save(user: User) : Long?
}