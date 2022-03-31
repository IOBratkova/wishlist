package com.ru.br.wishlist.business.service

import com.ru.br.wishlist.business.enity.User
import com.ru.br.wishlist.business.enity.UserCredentials

interface AuthRegService {
    fun findById(id: Long) : User
    fun findByUsername(username: String) : UserCredentials
}