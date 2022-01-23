package com.iramarfalcao.email.models

import com.iramarfalcao.email.enums.StatusEmail
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "TB_EMAIL")
data class Email(
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    var emailId: UUID?,
    val ownerRef: String,
    val emailFrom: String,
    val emailTo: String,
    val subject: String,
    @Column(columnDefinition = "TEXT")
    val text: String,
    var sendDateEmail: LocalDateTime?,
    var statusEmail: StatusEmail?
)