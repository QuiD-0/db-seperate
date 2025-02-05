package com.quid.cassette.infra.repository.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "cassette")
data class CassetteEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val owner: String,
    val description: String,
    @JoinColumn(name = "cassette_id", updatable = false, nullable = false)
    @OneToMany(cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    val musicList: List<MusicEntity>,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime? = null
) {

}
