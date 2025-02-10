package com.quid.cassette.api.response

import com.quid.cassette.domain.Cassette

data class CassetteInfoResponse(
    val id: Long,
    val owner: String,
    val title: String,
    val description: String,
) {
    constructor(cassette: Cassette) : this(
        id = cassette.id!!,
        owner = cassette.owner,
        title = cassette.title,
        description = cassette.description
    )
}
