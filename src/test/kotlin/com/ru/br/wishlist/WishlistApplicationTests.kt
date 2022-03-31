package com.ru.br.wishlist

import com.ru.br.wishlist.business.enity.User
import com.ru.br.wishlist.business.enity.UserCredentials
import com.ru.br.wishlist.business.repos.UserCredentialsRepo
import com.ru.br.wishlist.business.repos.UserRepo
import org.junit.jupiter.api.BeforeAll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
class WishlistApplicationTests {

	@Autowired
	lateinit var userCredentialsRepo: UserCredentialsRepo

	@Autowired
	lateinit var userRepo: UserRepo

	@Autowired
	lateinit var passwordEncoder: PasswordEncoder


	@BeforeAll
	fun setData() {
		createUserCredentials()
		createUser()
	}

	fun createUser() {
		val userCredentials = userCredentialsRepo.findById(1L).get()
		val user = User(
			1L,
			null,
			null,
			userCredentials,
			"Толя1",
			"Толев",
			"Толяля"
		)
		userCredentials.user = user
		userRepo.save(user)
	}

	fun createUserCredentials() {
		val userCredentials = UserCredentials(
			1L,
			null,
			null,
			"usernam1",
			passwordEncoder.encode("password1"),
			"user1@user1.user",
			"USER",
			null
		)
		userCredentialsRepo.save(userCredentials)
	}

}
