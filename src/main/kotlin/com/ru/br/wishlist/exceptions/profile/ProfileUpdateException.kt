package com.ru.br.wishlist.exceptions.profile

class ProfileUpdateException(id: Long) : Exception("Ошибка обновления профиля пользователя id = $id")