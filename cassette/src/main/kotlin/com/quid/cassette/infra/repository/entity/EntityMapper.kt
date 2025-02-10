package com.quid.cassette.infra.repository.entity

import com.quid.cassette.domain.Cassette
import com.quid.cassette.domain.CassettePlayList
import com.quid.cassette.domain.Music

object EntityMapper {
    fun toCassette(entity: CassetteEntity): Cassette {
        return Cassette(
            id = entity.id,
            owner = entity.owner,
            description = entity.description,
            createdAt = entity.createdAt,
            updatedAt = entity.updatedAt
        )
    }

    fun toEntity(cassette: Cassette): CassetteEntity {
        return CassetteEntity(
            id = cassette.id,
            owner = cassette.owner,
            description = cassette.description,
            createdAt = cassette.createdAt,
            updatedAt = cassette.updatedAt
        )
    }

    fun toEntity(cassettePlayList: CassettePlayList): CassettePlayListEntity {
        return CassettePlayListEntity(
            id = cassettePlayList.id,
            cassetteId = cassettePlayList.cassetteId,
            musicId = cassettePlayList.musicId,
            createdAt = cassettePlayList.createdAt
        )
    }

    fun toCassettePlayList(entity: CassettePlayListEntity): CassettePlayList {
        return CassettePlayList(
            id = entity.id,
            cassetteId = entity.cassetteId,
            musicId = entity.musicId,
            createdAt = entity.createdAt
        )
    }

    fun toMusic(entity: MusicEntity): Music {
        return Music(
            id = entity.id,
            title = entity.title,
            artist = entity.artist,
            link = entity.link
        )
    }

    fun toEntity(music: Music): MusicEntity {
        return MusicEntity(
            id = music.id,
            title = music.title,
            artist = music.artist,
            link = music.link
        )
    }
}
