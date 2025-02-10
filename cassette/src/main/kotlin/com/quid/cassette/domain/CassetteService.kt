package com.quid.cassette.domain

import com.quid.cassette.application.dto.CreateCassetteDto

interface CassetteService {
    fun createCassette(dto: CreateCassetteDto)
    fun updateDescription(id: Long, description: String)
}
