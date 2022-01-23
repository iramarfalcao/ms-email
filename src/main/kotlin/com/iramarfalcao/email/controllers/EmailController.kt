package com.iramarfalcao.email.controllers

import com.iramarfalcao.email.dtos.EmailDto
import com.iramarfalcao.email.models.Email
import com.iramarfalcao.email.services.EmailService
import com.iramarfalcao.email.utils.mapper.EmailMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
class EmailController(
    private val emailService: EmailService,
    private val emailMapper: EmailMapper
) {
    @PostMapping("/send-email")
    fun sendingEmail(@RequestBody emailDto: @Valid EmailDto): ResponseEntity<Email> {
        val email: Email = emailMapper.toEntity(emailDto)
        emailService.sendEmail(email)
        return ResponseEntity<Email>(email, HttpStatus.CREATED)
    }
}