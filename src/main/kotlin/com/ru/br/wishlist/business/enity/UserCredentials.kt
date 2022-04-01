package com.ru.br.wishlist.business.enity

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import lombok.RequiredArgsConstructor
import java.util.*
import javax.persistence.*

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "user_credentials")
data class UserCredentials (

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "updated")
    var updated: Date? = null,

    @Column(name = "created")
    var created: Date? = null,

    @Column(name = "username", nullable = false)
    var username: String,

    @Column(name = "password", nullable = false)
    var password: String,

    @Column(name = "email", nullable = false)
    var email: String,

    @Column(name = "role", nullable = false)
    var role: String

)
