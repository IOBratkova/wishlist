package com.ru.br.wishlist.rest.dto

import javax.validation.constraints.NotNull

class AuthReqDto (
    @NotNull
    val password: String,
    val username: String?,
    val email: String?
)
