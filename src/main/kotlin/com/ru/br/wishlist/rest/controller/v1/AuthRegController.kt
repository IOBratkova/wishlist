package com.ru.br.wishlist.rest.controller.v1

import com.ru.br.wishlist.business.service.auth.AuthRegService
import com.ru.br.wishlist.preferences.security.provider.JwtProvider
import com.ru.br.wishlist.rest.dto.AuthReqDto
import com.ru.br.wishlist.rest.dto.AuthTokenDto
import com.ru.br.wishlist.rest.dto.RegistrationReqDto
import com.ru.br.wishlist.rest.dto.RegistrationRespDto
import com.ru.br.wishlist.rest.mapper.UserCredentialsMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/auth")
class AuthRegController @Autowired constructor(
    private val authRegService: AuthRegService,
    private val userCredMapper: UserCredentialsMapper,
    private val jwtProvider: JwtProvider
) {
    @PostMapping("/registration")
    fun registration(@RequestBody request: RegistrationReqDto) : ResponseEntity<RegistrationRespDto> {
        val userCredentials = userCredMapper.toUserCredentials(request)
        return ResponseEntity<RegistrationRespDto>(
            RegistrationRespDto(authRegService.registration(userCredentials)), HttpStatus.OK
        )
    }

    @PostMapping("/auth")
    fun auth (@RequestBody request: AuthReqDto) : AuthTokenDto {
        val userCredentials = authRegService.auth(
            request.username,
            request.email,
            request.password
        )
        val token = jwtProvider.generateToken(userCredentials.username)
        return AuthTokenDto(token, userCredentials.id!!)
    }
}