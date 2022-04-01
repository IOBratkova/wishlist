package com.ru.br.wishlist.business.service.user

import com.ru.br.wishlist.business.enity.User
import com.ru.br.wishlist.business.repos.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl @Autowired constructor(
    private val userRepo: UserRepo
) : UserService {

    //TODO: Exception
    override fun findById(id: Long): User {
        return userRepo.findById(id)
            .orElseThrow{
                NullPointerException(id.toString())
            }
    }

    //TODO: Exception
    override fun findByUserCredentialId(id: Long): User {
        return userRepo.findByUserCredentialsId(id).orElseThrow {
            NullPointerException(id.toString())
        }
    }

    override fun save(user: User): User {
        return userRepo.saveAndFlush(user)
    }

}