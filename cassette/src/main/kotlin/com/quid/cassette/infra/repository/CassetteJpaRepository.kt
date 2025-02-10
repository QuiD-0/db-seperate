package com.quid.cassette.infra.repository

import com.quid.cassette.infra.repository.entity.CassetteEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CassetteJpaRepository : JpaRepository<CassetteEntity, Long> {
}
