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
@Table(name = "user_info")
data class User(

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "updated")
    @LastModifiedDate
    var updated: Date? = null,

    @Column(name = "created")
    @CreatedDate
    var created: Date? = null,

    @OneToOne
    @JoinColumn(name = "user_credentials_id", referencedColumnName = "id")
    var userCredentials: UserCredentials? = null,

    @Column(name = "first_name")
    val firstName: String? = "UNKNOWN",

    @Column(name = "second_name")
    val secondName: String? = "",

    @Column(name = "description")
    val description: String? = ""

)