package com.quid.cassette.application

import com.quid.cassette.domain.CassetteService
import com.quid.cassette.domain.PlayListService
import com.quid.cassette.application.dto.AddPlayListDto
import com.quid.cassette.application.dto.CreateCassetteDto
import com.quid.cassette.infra.repository.CassetteRepository
import com.quid.cassette.infra.repository.PlayListRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.support.TransactionTemplate

@Service
class CassetteCommand(
    private val cassetteRepository: CassetteRepository,
    private val playListRepository: PlayListRepository,
    private val transaction: TransactionTemplate
) : CassetteService, PlayListService {

    override fun createCassette(dto: CreateCassetteDto) {
        transaction.execute {
            val cassette = cassetteRepository.save(dto.toCassette())
            playListRepository.saveAll(dto.toPlayList(cassette.id!!))
        }
    }

    override fun updateDescription(id: Long, description: String) {
        val cassette = cassetteRepository.findById(id)
            .updateDescription(description)
        cassetteRepository.save(cassette)
    }

    override fun addPlayList(dto: List<AddPlayListDto>) {
        playListRepository.saveAll(dto.map { it.toPlayList() })
    }

    override fun removePlayList(playList: List<Long>) {
        playListRepository.deleteAll(playList)
    }
}
