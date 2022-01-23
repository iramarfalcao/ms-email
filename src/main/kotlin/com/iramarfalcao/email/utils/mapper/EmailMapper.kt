package com.iramarfalcao.email.utils.mapper

import com.iramarfalcao.email.dtos.EmailDto
import com.iramarfalcao.email.models.Email
import org.springframework.stereotype.Component

@Component
class EmailMapper : Mapper<Email, EmailDto> {
    override fun fromEntity(entity: Email): EmailDto =
        EmailDto(
            entity.ownerRef,
            entity.emailFrom,
            entity.emailTo,
            entity.subject,
            entity.text
        )

    override fun toEntity(domain: EmailDto): Email =
        Email(
            null,
            domain.ownerRef,
            domain.emailFrom,
            domain.emailTo,
            domain.subject,
            domain.text,
            null,
            null
        )
}