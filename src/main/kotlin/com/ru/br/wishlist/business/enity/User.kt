package com.ru.br.wishlist.business.enity

import lombok.Data
import lombok.NoArgsConstructor
import lombok.RequiredArgsConstructor
import org.springframework.context.annotation.Lazy
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
    var id: Long? = null,

    @Column(name = "updated")
    @LastModifiedDate
    var updated: Date? = null,

    @Column(name = "created")
    @CreatedDate
    var created: Date? = null,

    @OneToOne
    @Lazy
    @JoinColumn(name = "user_credentials_id", referencedColumnName = "id")
    var userCredentials: UserCredentials? = null,

    @Column(name = "first_name")
    var firstName: String? = "UNKNOWN",

    @Column(name = "second_name")
    var secondName: String? = "",

    @Column(name = "description")
    var description: String? = ""

)