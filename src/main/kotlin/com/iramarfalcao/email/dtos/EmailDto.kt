package com.iramarfalcao.email.dtos

import javax.validation.constraints.Email

data class EmailDto(
    val ownerRef: String,
    @Email val emailFrom: String,
    @Email val emailTo: String,
    val subject: String,
    val text: String
)