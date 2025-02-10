package com.quid.cassette.application.dto

import com.quid.cassette.domain.PlayList

data class AddPlayListDto(
    val cassetteId: Long,
    val title: String,
    val link: String
) {
    fun toPlayList(): PlayList {
        return PlayList(
            cassetteId = cassetteId,
            title = title,
            link = link
        )
    }
}
