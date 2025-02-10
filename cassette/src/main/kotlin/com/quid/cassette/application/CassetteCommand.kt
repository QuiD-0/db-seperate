package com.quid.cassette.application

import com.quid.cassette.application.dto.AddPlayListDto
import com.quid.cassette.application.dto.CreateCassetteDto
import com.quid.cassette.application.dto.CreatePlayListDto
import com.quid.cassette.infra.repository.CassetteRepository
import com.quid.cassette.infra.repository.PlayListRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.support.TransactionTemplate

@Service
class CassetteCommand(
    private val cassetteRepository: CassetteRepository,
    private val playListRepository: PlayListRepository,
    private val transaction: TransactionTemplate
) {

    fun createCassette(cassetteDto: CreateCassetteDto, playListDto: List<CreatePlayListDto>) {
        transaction.execute {
            val cassette = cassetteRepository.save(cassetteDto.toCassette())
            playListDto.map { it.toPlayList(cassette.id!!) }
                .let { playListRepository.saveAll(it) }
        }
    }

    fun updateDescription(id: Long, description: String) {
        val cassette = cassetteRepository.findById(id)
            .updateDescription(description)
        cassetteRepository.save(cassette)
    }

    fun addPlayList(dto: List<AddPlayListDto>) {
        playListRepository.saveAll(dto.map { it.toPlayList() })
    }

    fun removePlayList(playList: List<Long>) {
        playListRepository.deleteAll(playList)
    }
}
