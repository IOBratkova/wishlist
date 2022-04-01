package com.ru.br.wishlist.rest.mapper

import com.ru.br.wishlist.business.enity.UserCredentials
import com.ru.br.wishlist.rest.dto.RegistrationReqDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
interface UserCredentialsMapper {

    @Mapping(target = "role", constant = "USER")
    fun toUserCredentials(requestDto: RegistrationReqDto) : UserCredentials

//    fun toUserCredential(requestDto: RegisterRequestDto) : UserCredentials
//
//    fun toUserCredentialsDto(userCredentials: UserCredentials) : UserCredentialsDto
//
//    fun toUserCredentials(userCredentialsDto: UserCredentialsDto) : UserCredentials
}