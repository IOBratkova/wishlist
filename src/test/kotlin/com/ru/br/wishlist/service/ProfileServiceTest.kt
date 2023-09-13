package com.ru.br.wishlist.service

import com.ru.br.wishlist.WishlistApplicationTests
import com.ru.br.wishlist.business.service.profile.ProfileService
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProfileServiceTest @Autowired constructor(
    private val profileService: ProfileService
) : WishlistApplicationTests() {

}