package com.ru.br.wishlist.exceptions

import com.ru.br.wishlist.exceptions.reg.RegistrationException
import com.ru.br.wishlist.exceptions.user.UserNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
class ExceptionsHandler : ResponseEntityExceptionHandler() {

    data class ExceptionModel(val message: String, val exceptionTime: Date)

    @ExceptionHandler(value = [
        UserNotFoundException::class,
        RegistrationException::class
    ])
    fun handleException(e: Exception) : ResponseEntity<ExceptionModel> {
        val ex = ExceptionModel(e.message!!, Date())
        return ResponseEntity(ex, HttpStatus.BAD_REQUEST)
    }

}