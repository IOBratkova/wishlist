package com.ru.br.wishlist.service

import com.ru.br.wishlist.WishlistApplicationTests
import com.ru.br.wishlist.business.enity.UserCredentials
import com.ru.br.wishlist.business.service.auth.RegService
import com.ru.br.wishlist.exceptions.reg.RegistrationException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.orm.jpa.JpaSystemException

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RegServiceTest @Autowired constructor(
    private val regService: RegService
) : WishlistApplicationTests() {

    @Test
    fun `user exist by email`() {
        val userCredentials = UserCredentials(
            1L, null, null, "usernam1999", "password1", "user1@user1.user", "USER", null
        )
        val thrown = Assertions.assertThrows(JpaSystemException::class.java) {
            regService.registration(userCredentials)
        }
        Assertions.assertNotNull(thrown.message)
    }

    @Test
    fun `user exist by username`() {
        val userCredentials = UserCredentials(
            1L, null, null, "usernam1", "password1", "user1@user1.user", "USER", null
        )
        val thrown = Assertions.assertThrows(RegistrationException::class.java) {
            regService.registration(userCredentials)
        }
        Assertions.assertEquals(thrown.message, "Пользователь usernam1 существует.")
    }

    @Test
    fun `success registration`() {
        val userCredentials = UserCredentials(
            1L, null, null, "success", "password1", "success@success.success", "USER", null
        )
        val id = regService.registration(userCredentials);
        Assertions.assertNotNull(id)
    }

}