package com.ru.br.wishlist.business.service.user

import com.ru.br.wishlist.business.enity.UserCredentials
import com.ru.br.wishlist.business.repos.UserCredentialsRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class UserCredentialsServiceImpl @Autowired constructor(
    private val userCredentialsRepo: UserCredentialsRepo,
    private val passwordEncoder: PasswordEncoder
) : UserCredentialsService {

    //TODO: Exception
    override fun findById(id: Long): UserCredentials {
        return userCredentialsRepo.findById(id)
            .orElseThrow {
                NullPointerException(id.toString())
            }
    }

    //TODO: Exception
    override fun findByUsername(username: String): UserCredentials {
        return userCredentialsRepo.findFirstByUsername(username)
            .orElseThrow {
                NullPointerException(username)
            }
    }

    override fun findByEmail(email: String): UserCredentials {
        return userCredentialsRepo.findFirstByEmail(email)
            .orElseThrow {
                NullPointerException(email)
            }
    }

    //TODO: Exception
    override fun findUserByCredentials(email: String?, username: String?, password: String?): UserCredentials {
        return if (email == null)
            findByUsername(username!!)
        else
            findByEmail(email)
    }

    override fun existByUsername(username: String): Boolean {
        return userCredentialsRepo.existsByUsername(username)
    }

    override fun existByEmail(email: String): Boolean {
        return userCredentialsRepo.existsByEmail(email)
    }

    override fun save(userCredentials: UserCredentials): UserCredentials {
        return userCredentialsRepo.saveAndFlush(userCredentials)
    }

}