package com.quid.cassette.domain

import java.time.LocalDateTime

data class CassettePlayList(
    val id: Long? = null,
    val cassetteId: Long,
    val musicId: Long,
    val createdAt: LocalDateTime = LocalDateTime.now(),
) {
}
