package com.ru.br.wishlist.business.enity

import lombok.Data
import lombok.NoArgsConstructor
import lombok.RequiredArgsConstructor
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*
import javax.persistence.*

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener::class)
@Table(name = "user_credentials")
data class UserCredentials (

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "updated")
    @LastModifiedDate
    var updated: Date? = null,

    @Column(name = "created")
    @CreatedDate
    var created: Date? = null,

    @Column(name = "username", nullable = false)
    var username: String,

    @Column(name = "password", nullable = false)
    var password: String,

    @Column(name = "email", nullable = false)
    var email: String,

    @Column(name = "role", nullable = false)
    var role: String,

    @OneToOne(mappedBy = "userCredentials")
    var user: User? = null

)
