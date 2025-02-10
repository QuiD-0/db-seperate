package com.quid.cassette.api

import com.quid.cassette.application.CassetteCommand
import com.quid.cassette.application.CassetteQuery
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cassette")
class CassetteController(
    private val cassette: CassetteCommand,
    private val query: CassetteQuery
) {

}
