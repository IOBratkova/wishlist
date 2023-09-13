package com.ru.br.wishlist.business.service.auth

import com.ru.br.wishlist.business.enity.UserCredentials

interface AuthService {
    fun auth(username: String?, email: String?, password: String?) : UserCredentials
}