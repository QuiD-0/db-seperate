package com.quid.cassette.infra.repository.module

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class PlayListJdbcRepository(
    private val jdbc: NamedParameterJdbcTemplate
) {
    fun saveAll(dto: List<PlayListWriteDto>) {
        val query = """
            INSERT INTO playlist (cassette_id, title, link, created_at)
            VALUES (:cassetteId, :title, :link, :createdAt)
        """.trimIndent()
        val source = dto.map { it.toParameterSource() }.toTypedArray()

        jdbc.batchUpdate(query, source)
    }
}

data class PlayListWriteDto(
    val cassetteId: Long,
    val title: String,
    val link: String,
    val createdAt: LocalDateTime
) {
    fun toParameterSource() = MapSqlParameterSource()
        .addValue("cassetteId", cassetteId)
        .addValue("title", title)
        .addValue("link", link)
        .addValue("createdAt", createdAt)
}
