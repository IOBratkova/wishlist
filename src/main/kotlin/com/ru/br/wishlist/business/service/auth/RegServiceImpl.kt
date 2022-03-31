package com.ru.br.wishlist.business.service.auth

import com.ru.br.wishlist.business.enity.User
import com.ru.br.wishlist.business.enity.UserCredentials
import com.ru.br.wishlist.business.service.user.UserCredentialsService
import com.ru.br.wishlist.business.service.user.UserService
import com.ru.br.wishlist.exceptions.reg.RegistrationException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class RegServiceImpl @Autowired constructor(
    private val userCredentialsService: UserCredentialsService,
    private val userService: UserService,
    private val passwordEncoder: PasswordEncoder
) : RegService {

    override fun registration(userCredentials: UserCredentials): Long {
        if (userCredentialsService.existByUsername(userCredentials.username)) {
            throw RegistrationException(userCredentials.username)
        }
        if (userCredentialsService.existByEmail(userCredentials.email)) {
            throw RegistrationException(userCredentials.email)
        }
        userCredentials.password = passwordEncoder.encode(userCredentials.password)
        val user = User(null, null, null, userCredentials, "UNKNOWN", "", "")
        userCredentialsService.save(userCredentials).id!!
        return userService.save(user).id!!
    }

}