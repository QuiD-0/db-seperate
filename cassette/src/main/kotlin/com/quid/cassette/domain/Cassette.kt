package com.quid.cassette.domain

import java.time.LocalDateTime

data class Cassette(
    val id: Long? = null,
    val owner: String,
    val description: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = null
) {
}
