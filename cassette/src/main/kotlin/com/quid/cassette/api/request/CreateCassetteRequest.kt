package com.quid.cassette.api.request

data class CreateCassetteRequest(
    val owner: String,
    val title: String,
    val description: String,
)
