package com.ru.br.wishlist.business.service.user

import com.ru.br.wishlist.business.enity.UserCredentials
import com.ru.br.wishlist.business.repos.UserCredentialsRepo
import com.ru.br.wishlist.exceptions.user.UserNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UserCredentialsServiceImpl @Autowired constructor(
    private val userCredentialsRepo: UserCredentialsRepo
) : UserCredentialsService {

    override fun findById(id: Long): UserCredentials {
        return userCredentialsRepo.findById(id)
            .orElseThrow {
                UserNotFoundException("id $id")
            }
    }

    override fun findByUsername(username: String): UserCredentials {
        return userCredentialsRepo.findFirstByUsername(username)
            .orElseThrow {
                UserNotFoundException("username $username")
            }
    }

    override fun findByEmail(email: String): UserCredentials {
        return userCredentialsRepo.findFirstByEmail(email)
            .orElseThrow {
                UserNotFoundException("email $email")
            }
    }

    override fun findUserByCredentials(email: String?, username: String?, password: String?): UserCredentials {
        return if (email == null) findByUsername(username!!)
        else findByEmail(email)
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