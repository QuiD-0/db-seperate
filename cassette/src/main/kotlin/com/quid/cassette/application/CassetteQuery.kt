package com.quid.cassette.application

import com.quid.cassette.domain.Cassette
import com.quid.cassette.infra.repository.CassetteRepository
import org.springframework.stereotype.Service

@Service
class CassetteQuery(
    private val cassetteRepository: CassetteRepository
) {
    fun getCassetteBy(id: Long): Cassette {
        return cassetteRepository.findById(id)
    }
}
