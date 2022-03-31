package com.ru.br.wishlist.exceptions.reg

class RegistrationException(cred: String) : Exception("Пользователь $cred существует.")
