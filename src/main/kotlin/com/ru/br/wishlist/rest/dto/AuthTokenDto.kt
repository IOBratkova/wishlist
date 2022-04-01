package com.ru.br.wishlist.rest.dto

import com.fasterxml.jackson.annotation.JsonProperty

class AuthTokenDto (
    val token: String,
    val id: Long
)