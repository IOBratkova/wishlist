package com.ru.br.wishlist.business.service.auth

import com.ru.br.wishlist.business.enity.User
import com.ru.br.wishlist.business.enity.UserCredentials
import com.ru.br.wishlist.business.service.user.UserCredentialsService
import com.ru.br.wishlist.preferences.security.provider.JwtProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthRegServiceImpl @Autowired constructor(
    private val userCredentialsService: UserCredentialsService,
    private val jwtProvider: JwtProvider,
    private val passwordEncoder: PasswordEncoder
) : AuthRegService {

    //TODO: Exception
    override fun registration(userCredentials: UserCredentials): Long {
        if (userCredentialsService.existByUsername(userCredentials.username)) {
            throw NullPointerException(userCredentials.username)
        }
        if (userCredentialsService.existByEmail(userCredentials.email)) {
            throw NullPointerException(userCredentials.username)
        }
        userCredentials.password = passwordEncoder.encode(userCredentials.password)
        return userCredentialsService.save(userCredentials).id!!
    }

    //TODO: Exception
    override fun auth(username: String?, email: String?, password: String?): UserCredentials {
        if (email == null && username == null || password === null) {
            throw NullPointerException("sss")
        }
        return if (email == null)
            validatePassword(password, userCredentialsService.findByUsername(username!!))
        else
            validatePassword(password, userCredentialsService.findByEmail(email))
    }

    //TODO: Exception
    private fun validatePassword(password: String, userCridentials: UserCredentials): UserCredentials {
        if (passwordEncoder.matches(password, userCridentials.password)) {
            return userCridentials
        }
        throw NullPointerException(password)
    }

}