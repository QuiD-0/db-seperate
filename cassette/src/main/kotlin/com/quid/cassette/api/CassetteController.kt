package com.quid.cassette.api

import com.quid.cassette.api.request.CreateCassetteRequest
import com.quid.cassette.api.response.CassetteInfoResponse
import com.quid.cassette.application.CassetteCommand
import com.quid.cassette.application.CassetteQuery
import com.quid.cassette.application.dto.CreateCassetteDto
import com.quid.cassette.application.dto.CreatePlayListDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cassette")
class CassetteController(
    private val command: CassetteCommand,
    private val query: CassetteQuery
) {
    @PostMapping
    fun createCassette(
        @RequestBody request: CreateCassetteRequest,
    ) {
        command.createCassette(
            CreateCassetteDto(
                owner = request.owner,
                title = request.title,
                description = request.description,
            ),
            request.playList.map {
                CreatePlayListDto(
                    title = it.title,
                    link = it.link
                )
            }
        )
    }

    @GetMapping("/{id}")
    fun getCassette(@PathVariable id: Long): CassetteInfoResponse {
        return query.getCassetteBy(id)
            .run { CassetteInfoResponse(this) }
    }
}
