package com.ru.br.wishlist.preferences.security.details

import com.ru.br.wishlist.business.service.user.UserCredentialsService
import com.ru.br.wishlist.preferences.security.principal.UserPrincipal
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserWishDetailServiceImpl @Autowired constructor(
    private val userCredService: UserCredentialsService
): UserWishDetailService, UserDetailsService {

    override fun loadUserById(id: Long): UserDetails {
        val user = userCredService.findById(id)
        return UserPrincipal.create(user)
    }

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userCredService.findByUsername(username)
        return UserPrincipal.create(user)
    }
}