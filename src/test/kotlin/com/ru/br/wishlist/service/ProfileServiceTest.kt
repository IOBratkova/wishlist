package com.ru.br.wishlist.service

import com.ru.br.wishlist.WishlistApplicationTests
import com.ru.br.wishlist.business.service.profile.ProfileService
import com.ru.br.wishlist.business.service.user.UserService
import com.ru.br.wishlist.exceptions.user.UserNotFoundException
import com.ru.br.wishlist.rest.dto.UserDto
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProfileServiceTest @Autowired constructor(
    private val profileService: ProfileService,
    private val userService: UserService
) : WishlistApplicationTests() {

    @Test
    fun `update full profile`() {
        var dto = UserDto(1L, "Name", "Fname", "dsc")
        var res = profileService.update(dto)
        var user = userService.findById(1L)
        Assertions.assertEquals(1, res)
        Assertions.assertEquals(user.firstName, dto.firstName)
        Assertions.assertEquals(user.secondName, dto.secondName)
    }

    @Test
    fun `update name profile`() {
        var dto = UserDto(1L, "Name", null, null)
        var res = profileService.update(dto)
        var user = userService.findById(1L)
        Assertions.assertEquals(1, res)
        Assertions.assertEquals(user.firstName, dto.firstName)
        Assertions.assertEquals(user.secondName, dto.secondName)
    }

    @Test
    fun `update second name profile`() {
        var dto = UserDto(1L, null, "null", null)
        var res = profileService.update(dto)
        var user = userService.findById(1L)
        Assertions.assertEquals(1, res)
        Assertions.assertEquals(user.firstName, dto.firstName)
        Assertions.assertEquals(user.secondName, dto.secondName)
    }

    @Test
    fun `update description profile`() {
        var dto = UserDto(1L, null, null, "null")
        var res = profileService.update(dto)
        var user = userService.findById(1L)
        Assertions.assertEquals(1, res)
        Assertions.assertEquals(user.firstName, dto.firstName)
        Assertions.assertEquals(user.secondName, dto.secondName)
    }

    @Test
    fun `user not found exception`() {
        var dto = UserDto(10L, null, null, "null")
        var res = Assertions.assertThrows(UserNotFoundException::class.java) {
            profileService.update(dto)
        }
        Assertions.assertEquals("Пользователь 10 не найден.", res.message)
    }
}