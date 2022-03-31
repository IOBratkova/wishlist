package com.ru.br.wishlist.service

import com.ru.br.wishlist.WishlistApplicationTests
import com.ru.br.wishlist.business.service.auth.AuthService
import com.ru.br.wishlist.exceptions.auth.IncorrectCredentialsException
import com.ru.br.wishlist.exceptions.user.UserNotFoundException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AuthServiceTest @Autowired constructor(
    private val authService: AuthService
) : WishlistApplicationTests() {

    @Test
    fun `can not auth`() {
        var thrown = Assertions.assertThrows(IncorrectCredentialsException::class.java) {
            authService.auth(null, null, "fsdfsf")
        }
        Assertions.assertEquals(thrown.message, "Некорректные параметры запроса")

        thrown = Assertions.assertThrows(IncorrectCredentialsException::class.java) {
            authService.auth("null", "null", null)
        }
        Assertions.assertEquals(thrown.message, "Некорректные параметры запроса")

        thrown = Assertions.assertThrows(IncorrectCredentialsException::class.java) {
            authService.auth(null, "null", null)
        }
        Assertions.assertEquals(thrown.message, "Некорректные параметры запроса")

        thrown = Assertions.assertThrows(IncorrectCredentialsException::class.java) {
            authService.auth("null", null, null)
        }
        Assertions.assertEquals(thrown.message, "Некорректные параметры запроса")
    }

    @Test
    fun `can not auth by email`() {
        var user = Assertions.assertThrows(UserNotFoundException::class.java) {
            authService.auth(null, "user1@user1.users", "password1s")
        }
        Assertions.assertNotNull(user)
        Assertions.assertEquals(user.message, "Пользователь email user1@user1.users не найден.")
    }

    @Test
    fun `can not auth by username`() {
        var user = Assertions.assertThrows(UserNotFoundException::class.java) {
            authService.auth("usernam1s", null, "password1s")
        }
        Assertions.assertNotNull(user)
        Assertions.assertEquals(user.message, "Пользователь username usernam1s не найден.")
    }
}