package com.ru.br.wishlist.business.service.auth

import com.ru.br.wishlist.business.enity.UserCredentials
import com.ru.br.wishlist.business.service.user.UserCredentialsService
import com.ru.br.wishlist.exceptions.auth.IncorrectCredentialsException
import com.ru.br.wishlist.exceptions.auth.ValidatePasswordException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl @Autowired constructor(
    private val userCredentialsService: UserCredentialsService,
    private val passwordEncoder: PasswordEncoder
) : AuthService {

    override fun auth(username: String?, email: String?, password: String?): UserCredentials {
        if (email == null && username == null || password === null) {
            throw IncorrectCredentialsException()
        }
        return if (email == null)
            validatePassword(password, userCredentialsService.findByUsername(username!!))
        else
            validatePassword(password, userCredentialsService.findByEmail(email))
    }

    private fun validatePassword(password: String, userCridentials: UserCredentials): UserCredentials {
        if (passwordEncoder.matches(password, userCridentials.password)) {
            return userCridentials
        }
        throw ValidatePasswordException()
    }

}