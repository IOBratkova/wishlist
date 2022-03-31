package com.ru.br.wishlist.business.service.auth

import com.ru.br.wishlist.business.enity.UserCredentials
import org.springframework.stereotype.Service

@Service
interface RegService {
    fun registration(userCredentials: UserCredentials) : Long
}