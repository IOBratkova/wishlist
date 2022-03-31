package com.ru.br.wishlist.business.service

import com.ru.br.wishlist.business.enity.User
import com.ru.br.wishlist.business.enity.UserCredentials
import com.ru.br.wishlist.business.repos.UserCredentialsRepo
import com.ru.br.wishlist.business.repos.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthRegServiceImpl @Autowired constructor(
    private val userRepo: UserRepo,
    private val userCredentialsRepo: UserCredentialsRepo
) : AuthRegService {

    //TODO: Exception
    override fun findById(id: Long): User {
        return userRepo.findById(id)
            .orElseThrow{
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

}