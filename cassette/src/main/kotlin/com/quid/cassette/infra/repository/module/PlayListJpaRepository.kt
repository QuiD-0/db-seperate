package com.quid.cassette.infra.repository.module

import com.quid.cassette.infra.repository.entity.PlayListEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PlayListJpaRepository: JpaRepository<PlayListEntity, Long> {
    fun findByCassetteId(cassetteId: Long): List<PlayListEntity>
}
