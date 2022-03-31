package com.ru.br.wishlist.exceptions.user

class UserNotFoundException(cred: String) : Exception("Пользователь $cred не найден.")
