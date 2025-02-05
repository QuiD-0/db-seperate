package com.quid.cassette.domain

data class Music(
    val id: Long? = null,
    val title: String,
    val artist: String,
    val link: String
) {
}
