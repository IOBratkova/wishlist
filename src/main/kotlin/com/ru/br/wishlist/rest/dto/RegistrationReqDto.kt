package com.ru.br.wishlist.rest.dto

import com.sun.istack.NotNull

data class RegistrationReqDto (
    @NotNull val username: String,
    @NotNull val password: String,
    @NotNull val email: String
)
