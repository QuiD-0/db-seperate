package com.quid.cassette.infra.repository

import com.quid.cassette.domain.Cassette
import com.quid.cassette.infra.repository.module.CassetteJpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import com.quid.cassette.infra.repository.entity.EntityMapper as mapper

@Repository
class CassetteRepository(
    private val cassetteJpaRepository: CassetteJpaRepository
) {

    fun save(cassette: Cassette): Cassette {
        return cassetteJpaRepository.save(mapper.toEntity(cassette))
            .let { mapper.toCassette(it) }
    }

    fun findById(id: Long): Cassette {
        return cassetteJpaRepository.findByIdOrNull(id)
            ?.let { mapper.toCassette(it) }
            ?: throw IllegalArgumentException("Cassette not found")
    }

}
