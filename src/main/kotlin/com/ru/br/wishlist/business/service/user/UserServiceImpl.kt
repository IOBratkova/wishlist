package com.ru.br.wishlist.business.service.user

import com.ru.br.wishlist.business.enity.User
import com.ru.br.wishlist.business.repos.UserRepo
import com.ru.br.wishlist.exceptions.user.UserNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl @Autowired constructor(
    private val userRepo: UserRepo
) : UserService {

    override fun findById(id: Long): User {
        return userRepo.findById(id)
            .orElseThrow{
                UserNotFoundException(id.toString())
            }
    }

    override fun findByUserCredentialId(id: Long): User {
        return userRepo.findByUserCredentialsId(id).orElseThrow {
            UserNotFoundException(id.toString())
        }
    }

    override fun save(user: User): Long? {
        return userRepo.saveAndFlush(user).id
    }

}