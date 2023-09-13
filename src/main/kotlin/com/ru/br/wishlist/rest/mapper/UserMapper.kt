package com.ru.br.wishlist.rest.mapper

import com.ru.br.wishlist.business.enity.User
import com.ru.br.wishlist.business.enity.UserCredentials
import com.ru.br.wishlist.rest.dto.RegistrationReqDto
import com.ru.br.wishlist.rest.dto.UserDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
interface UserMapper {

    @Mapping(target = "role", constant = "USER")
    fun toUserCredentials(requestDto: RegistrationReqDto) : UserCredentials

    fun toUser(userDto: UserDto) : User

    fun updateUser(userDto: UserDto, @MappingTarget user: User)

}