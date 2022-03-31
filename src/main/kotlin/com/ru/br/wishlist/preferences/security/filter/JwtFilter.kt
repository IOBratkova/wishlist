package com.ru.br.wishlist.preferences.security.filter

import com.ru.br.wishlist.preferences.security.details.UserWishDetailService
import com.ru.br.wishlist.preferences.security.provider.JwtProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Service
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Service
class JwtFilter @Autowired constructor(
    private val jwtProvider: JwtProvider,
    private val userWishDetailService: UserWishDetailService
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val jwt = getJwtFromRequest(request)
        if (!jwt.isNullOrEmpty() && jwtProvider.validateToken(jwt)) {
            val username = jwtProvider.getUsernameFromToken(jwt)
            val userDetails = userWishDetailService.loadUserByUsername(username)
            val authentication = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
            authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
            SecurityContextHolder.getContext().authentication = authentication
        }
        filterChain.doFilter(request, response)
    }

    fun getJwtFromRequest(request: HttpServletRequest): String? {
        return try {
            request.getHeader("Authorization")
        } catch (ex: NullPointerException) {
            null
        }
    }

}