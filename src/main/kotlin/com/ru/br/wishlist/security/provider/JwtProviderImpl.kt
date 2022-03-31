package com.ru.br.wishlist.security.provider

import org.springframework.stereotype.Service

@Service
class JwtProviderImpl : JwtProvider {
    override fun generateToken(username: String): String {
        TODO("Not yet implemented")
    }

    override fun validateToken(token: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun getUserIdFromToken(token: String): Long {
        TODO("Not yet implemented")
    }

    override fun getUsernameFromToken(token: String): String {
        TODO("Not yet implemented")
    }
}