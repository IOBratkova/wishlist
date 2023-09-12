package com.ru.br.wishlist.rest.controller.v1

import com.ru.br.wishlist.business.service.profile.ProfileService
import com.ru.br.wishlist.rest.dto.IdDto
import com.ru.br.wishlist.rest.dto.UserDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/profile")
class ProfileController @Autowired constructor(
    private val profileService: ProfileService
) {

    @PostMapping("")
    fun registration(@RequestBody request: UserDto) : ResponseEntity<IdDto> {
        return ResponseEntity<IdDto>(
            IdDto(profileService.update(request)), HttpStatus.OK
        )
    }
}