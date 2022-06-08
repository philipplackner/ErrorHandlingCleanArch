package com.plcoding.errorhandlingcleanarch.domain

import com.plcoding.errorhandlingcleanarch.util.Resource

interface MyRepository {
    suspend fun submitEmail(email: String): Resource<Unit>
}