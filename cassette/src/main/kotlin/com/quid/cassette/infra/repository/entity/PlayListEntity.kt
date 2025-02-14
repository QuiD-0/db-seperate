package com.quid.cassette.infra.repository.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "playlist")
data class PlayListEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val cassetteId: Long,
    val title: String,
    val link: String,
    val createdAt: LocalDateTime
) {
}
