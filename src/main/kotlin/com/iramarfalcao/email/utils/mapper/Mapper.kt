package com.iramarfalcao.email.utils.mapper

interface Mapper<E, D> {
    fun fromEntity(entity: E): D
    fun toEntity(domain: D): E
}
