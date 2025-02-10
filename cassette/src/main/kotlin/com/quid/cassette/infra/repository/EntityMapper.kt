package com.quid.cassette.infra.repository

import com.quid.cassette.domain.Cassette
import com.quid.cassette.domain.PlayList
import com.quid.cassette.infra.repository.component.PlayListWriteDto
import com.quid.cassette.infra.repository.entity.CassetteEntity
import com.quid.cassette.infra.repository.entity.PlayListEntity

object EntityMapper {
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

    fun toEntity(cassettePlayList: PlayList): PlayListEntity {
        return PlayListEntity(
            id = cassettePlayList.id,
            cassetteId = cassettePlayList.cassetteId,
            title = cassettePlayList.title,
            link = cassettePlayList.link,
            createdAt = cassettePlayList.createdAt
        )
    }

    fun toWriteDto(playList: PlayList): PlayListWriteDto {
        return PlayListWriteDto(
            cassetteId = playList.cassetteId,
            title = playList.title,
            link = playList.link,
            createdAt = playList.createdAt
        )
    }

    fun toWriteDto(playList: List<PlayList>): List<PlayListWriteDto> {
        return playList.map { toWriteDto(it) }
    }

    fun toCassettePlayList(entity: PlayListEntity): PlayList {
        return PlayList(
            id = entity.id,
            cassetteId = entity.cassetteId,
            title = entity.title,
            link = entity.link,
            createdAt = entity.createdAt
        )
    }
}
