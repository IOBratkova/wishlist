package com.ru.br.wishlist.business.service.auth

import com.ru.br.wishlist.business.enity.UserCredentials
import org.springframework.stereotype.Service

@Service
interface AuthService {
    fun auth(username: String?, email: String?, password: String?) : UserCredentials
}