package com.ru.br.wishlist.preferences.security.principal

import com.ru.br.wishlist.business.enity.UserCredentials
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserPrincipal (
    private val username: String,
    private val password: String,
    private val roles: MutableList<out GrantedAuthority>,
    private val id: Long
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return roles
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    companion object {
        fun create(user: UserCredentials) : UserPrincipal {
            return UserPrincipal(
                user.username,
                user.password,
                mutableListOf(SimpleGrantedAuthority("ROLE_" + user.role)),
                user.id!!
            )
        }
    }
}