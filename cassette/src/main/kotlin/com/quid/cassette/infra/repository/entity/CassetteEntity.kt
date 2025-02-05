package com.quid.cassette.infra.repository.entity

import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "cassette")
data class CassetteEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val owner: String,
    val description: String,
    @ElementCollection
    val musicIds: List<Long>,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime? = null
) {

}
