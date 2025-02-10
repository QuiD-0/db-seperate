package com.quid.cassette.domain

import com.quid.cassette.infra.repository.component.PlayListJdbcBulkWriteDto
import com.quid.cassette.infra.repository.entity.PlayListEntity

object PlayListMapper {

    fun toEntity(cassettePlayList: PlayList): PlayListEntity {
        return PlayListEntity(
            id = cassettePlayList.id,
            cassetteId = cassettePlayList.cassetteId,
            title = cassettePlayList.title,
            link = cassettePlayList.link,
            createdAt = cassettePlayList.createdAt
        )
    }

    fun toWriteDto(playList: PlayList): PlayListJdbcBulkWriteDto {
        return PlayListJdbcBulkWriteDto(
            cassetteId = playList.cassetteId,
            title = playList.title,
            link = playList.link,
            createdAt = playList.createdAt
        )
    }

    fun toWriteDto(playList: List<PlayList>): List<PlayListJdbcBulkWriteDto> {
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
