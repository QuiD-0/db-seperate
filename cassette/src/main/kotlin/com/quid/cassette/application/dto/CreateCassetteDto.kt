package com.quid.cassette.application.dto

import com.quid.cassette.domain.Cassette
import com.quid.cassette.domain.PlayList

data class CreateCassetteDto(
    val owner: String,
    val title: String,
    val description: String,
) {
    fun toCassette(): Cassette {
        return Cassette(
            owner = owner,
            title = title,
            description = description
        )
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
