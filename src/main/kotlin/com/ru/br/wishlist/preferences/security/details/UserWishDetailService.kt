package com.ru.br.wishlist.preferences.security.details

import org.springframework.security.core.userdetails.UserDetails

interface UserWishDetailService {
    fun loadUserById(id: Long) : UserDetails
    fun loadUserByUsername(username: String) : UserDetails
}