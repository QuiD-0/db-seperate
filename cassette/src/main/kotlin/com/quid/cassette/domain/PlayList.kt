package com.quid.cassette.domain

import java.time.LocalDateTime

data class PlayList(
    val id: Long? = null,
    val cassetteId: Long,
    val title: String,
    val link: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
) {
}
