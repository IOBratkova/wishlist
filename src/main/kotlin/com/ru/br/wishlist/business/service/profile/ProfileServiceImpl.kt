package com.ru.br.wishlist.business.service.profile

import com.ru.br.wishlist.business.service.user.UserService
import com.ru.br.wishlist.exceptions.profile.ProfileUpdateException
import com.ru.br.wishlist.rest.dto.UserDto
import com.ru.br.wishlist.rest.mapper.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProfileServiceImpl @Autowired constructor(
    private val userMapper: UserMapper,
    private val userService: UserService
) : ProfileService {

    override fun update(userDto: UserDto): Long {
        var user = userService.findById(userDto.id)
        userMapper.updateUser(userDto, user)
        return userService.save(user) ?: throw ProfileUpdateException(userDto.id)
    }

}