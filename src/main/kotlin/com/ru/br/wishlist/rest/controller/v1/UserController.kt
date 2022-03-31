package com.ru.br.wishlist.rest.controller.v1

import com.ru.br.wishlist.business.service.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/user")
class UserController @Autowired constructor(
    private val userService: UserService
) {
}