package com.ru.br.wishlist.preferences.security.provider

interface JwtProvider {

    fun generateToken(username: String) : String

    fun validateToken(token: String): Boolean

    fun getUserIdFromToken(token: String) : Long

    fun getUsernameFromToken(token: String) : String

}