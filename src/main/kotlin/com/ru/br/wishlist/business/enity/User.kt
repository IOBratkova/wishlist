package com.ru.br.wishlist.business.enity

import lombok.Data
import java.util.*
import javax.persistence.*

@Entity
@Data
@Table(name = "user")
data class User(

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "created", updatable = false)
    var created: Date? = null,

    @Column(name = "updated")
    var updated: Date? = null,

    @OneToOne
    @JoinColumn(name = "user_credentials_id", referencedColumnName = "id")
    var userCredentials: UserCredentials? = null,

    @Column(name = "first_name")
    val firstName: String? = "UNKNOWN",

    @Column(name = "second_name")
    val secondName: String?,

    @Column(name = "patronymic")
    val patronymic: String?,

    @Column(name = "description")
    val description: String?,

    @Column(name = "avatar")
    var avatar: String? = null

)