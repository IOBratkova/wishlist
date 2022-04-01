package com.ru.br.wishlist.business.service.auth

import com.ru.br.wishlist.business.enity.UserCredentials
import org.springframework.stereotype.Service

@Service
interface AuthRegService {
    fun registration(userCredentials: UserCredentials) : Long
    fun auth(username: String?, email: String?, password: String?) : UserCredentials
}