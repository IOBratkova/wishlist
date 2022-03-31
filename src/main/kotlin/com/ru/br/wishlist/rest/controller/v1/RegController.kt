package com.ru.br.wishlist.rest.controller.v1

import com.ru.br.wishlist.business.service.auth.RegService
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
@RequestMapping("v1/registration")
class RegController @Autowired constructor(
    private val regService: RegService,
    private val userCredMapper: UserCredentialsMapper
) {
    @PostMapping("")
    fun registration(@RequestBody request: RegistrationReqDto) : ResponseEntity<RegistrationRespDto> {
        val userCredentials = userCredMapper.toUserCredentials(request)
        return ResponseEntity<RegistrationRespDto>(
            RegistrationRespDto(regService.registration(userCredentials)), HttpStatus.OK
        )
    }
}