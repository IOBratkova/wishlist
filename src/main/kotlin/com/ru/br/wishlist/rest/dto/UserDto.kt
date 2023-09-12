package com.ru.br.wishlist.rest.dto

import javax.validation.constraints.NotNull

data class UserDto (
    @NotNull val id: Long,
    val firstName: String?,
    val secondName: String?,
    val description: String?
)
