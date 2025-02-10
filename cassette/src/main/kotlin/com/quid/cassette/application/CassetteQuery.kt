package com.quid.cassette.application

import com.quid.cassette.domain.Cassette
import com.quid.cassette.infra.repository.CassetteRepository
import org.springframework.stereotype.Service

@Service
class CassetteQuery(
    private val cassetteRepository: CassetteRepository
) {
    fun getCassetteBy(userId: Long): Cassette {
        return cassetteRepository.findById(userId)
    }
}
