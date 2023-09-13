package com.ru.br.wishlist.business.service.profile

import com.ru.br.wishlist.rest.dto.UserDto

interface ProfileService {
    fun update(userDto: UserDto) : Long
}