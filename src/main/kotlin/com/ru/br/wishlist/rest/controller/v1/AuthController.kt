package com.ru.br.wishlist.rest.controller.v1

import com.ru.br.wishlist.business.service.auth.AuthService
import com.ru.br.wishlist.preferences.security.provider.JwtProvider
import com.ru.br.wishlist.rest.dto.AuthReqDto
import com.ru.br.wishlist.rest.dto.AuthTokenDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/auth")
class AuthController @Autowired constructor(
    private val authService: AuthService,
    private val jwtProvider: JwtProvider
) {

    @GetMapping("")
    fun auth (@RequestBody request: AuthReqDto) : AuthTokenDto {
        val userCredentials = authService.auth(
            request.username,
            request.email,
            request.password
        )
        val token = jwtProvider.generateToken(userCredentials.username)
        return AuthTokenDto(token, userCredentials.id!!)
    }
}