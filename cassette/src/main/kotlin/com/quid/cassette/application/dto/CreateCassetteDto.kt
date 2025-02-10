package com.quid.cassette.application.dto

import com.quid.cassette.domain.Cassette
import com.quid.cassette.domain.PlayList

data class CreateCassetteDto(
    val owner: String,
    val title: String,
    val description: String,
    val playList: List<CreatePlayListDto>
) {
    fun toCassette(): Cassette {
        return Cassette(
            owner = owner,
            title = title,
            description = description
        )
    }

    fun toPlayList(cassetteId: Long): List<PlayList> {
        return playList.map { it.toPlayList(cassetteId) }
    }
}

data class CreatePlayListDto(
    val title: String,
    val link: String
) {
    fun toPlayList(cassetteId: Long): PlayList {
        return PlayList(
            cassetteId = cassetteId,
            title = title,
            link = link
        )
    }
}
