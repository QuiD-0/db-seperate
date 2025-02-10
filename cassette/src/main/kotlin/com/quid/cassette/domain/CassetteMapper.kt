package com.quid.cassette.domain

import com.quid.cassette.infra.repository.entity.CassetteEntity

object CassetteMapper {
    fun toCassette(entity: CassetteEntity): Cassette {
        return Cassette(
            id = entity.id,
            owner = entity.owner,
            title = entity.title,
            description = entity.description,
            createdAt = entity.createdAt,
            updatedAt = entity.updatedAt
        )
    }

    fun toEntity(cassette: Cassette): CassetteEntity {
        return CassetteEntity(
            id = cassette.id,
            owner = cassette.owner,
            title = cassette.title,
            description = cassette.description,
            createdAt = cassette.createdAt,
            updatedAt = cassette.updatedAt
        )
    }

}
