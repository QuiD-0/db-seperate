package com.quid.cassette.infra.repository

import com.quid.cassette.domain.PlayList
import com.quid.cassette.domain.PlayListMapper
import com.quid.cassette.infra.repository.component.PlayListJdbcRepository
import com.quid.cassette.infra.repository.component.PlayListJpaRepository
import org.springframework.stereotype.Repository

@Repository
class PlayListRepository(
    private val playListJpaRepository: PlayListJpaRepository,
    private val playListJdbcRepository: PlayListJdbcRepository
) {

    fun findByCassetteId(cassetteId: Long): List<PlayList> {
        return playListJpaRepository.findByCassetteId(cassetteId)
            .map { PlayListMapper.toCassettePlayList(it) }
    }

    fun saveAll(playList: List<PlayList>) {
        if (playList.isEmpty()) return
        playListJdbcRepository.saveAll(PlayListMapper.toWriteDto(playList))
    }

    fun deleteAll(playList: List<Long>) {
        if (playList.isEmpty()) return
        playListJdbcRepository.deleteAllById(playList)
    }

}
