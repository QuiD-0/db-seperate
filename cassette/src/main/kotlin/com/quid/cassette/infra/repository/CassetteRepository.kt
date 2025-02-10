package com.quid.cassette.infra.repository

import com.quid.cassette.domain.Cassette
import com.quid.cassette.infra.repository.component.CassetteJpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import com.quid.cassette.infra.repository.entity.EntityMapper as mapper

@Repository
@Transactional
class CassetteRepository(
    private val cassetteJpaRepository: CassetteJpaRepository
) {

    fun save(cassette: Cassette): Cassette {
        return cassetteJpaRepository.save(mapper.toEntity(cassette))
            .let { mapper.toCassette(it) }
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): Cassette {
        return cassetteJpaRepository.findByIdOrNull(id)
            ?.let { mapper.toCassette(it) }
            ?: throw IllegalArgumentException("Cassette not found")
    }
}
