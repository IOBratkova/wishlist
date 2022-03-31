package com.ru.br.wishlist.preferences.security.details

import com.ru.br.wishlist.business.service.AuthRegService
import com.ru.br.wishlist.preferences.security.principal.UserPrincipal
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserWishDetailServiceImpl @Autowired constructor(
    private val userService: AuthRegService
): UserWishDetailService, UserDetailsService {

    override fun loadUserById(id: Long): UserDetails {
        val user = userService.findById(id)
        return UserPrincipal.create(user.userCredentials!!)
    }

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userService.findByUsername(username)
        return UserPrincipal.create(user)
    }
}