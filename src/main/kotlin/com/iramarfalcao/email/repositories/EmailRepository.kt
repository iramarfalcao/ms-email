package com.iramarfalcao.email.repositories

import com.iramarfalcao.email.models.Email
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface EmailRepository : JpaRepository<Email, UUID>