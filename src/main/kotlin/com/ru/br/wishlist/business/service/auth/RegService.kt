package com.ru.br.wishlist.business.service.auth

import com.ru.br.wishlist.business.enity.UserCredentials

interface RegService {
    fun registration(userCredentials: UserCredentials) : Long
}