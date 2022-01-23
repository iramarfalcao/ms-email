package com.iramarfalcao.email.services

import com.iramarfalcao.email.enums.StatusEmail
import com.iramarfalcao.email.models.Email
import com.iramarfalcao.email.repositories.EmailRepository
import org.springframework.mail.MailException
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class EmailService(
    private val emailRepository: EmailRepository,
    private val javaMailSender: JavaMailSender
) {
    fun sendEmail(email: Email): Email {

        email.sendDateEmail = LocalDateTime.now()

        try {
            val message = SimpleMailMessage()
            message.setFrom(email.emailFrom)
            message.setTo(email.emailTo)
            message.setSubject(email.subject)
            message.setText(email.text)
            javaMailSender.send(message)

            email.statusEmail = StatusEmail.SENT
        } catch (e: MailException) {
            email.statusEmail = StatusEmail.ERROR
        }

        return emailRepository.save(email)
    }
}