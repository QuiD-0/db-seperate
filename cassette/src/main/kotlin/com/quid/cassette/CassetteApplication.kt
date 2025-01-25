package com.quid.cassette

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CassetteApplication

fun main(args: Array<String>) {
    runApplication<CassetteApplication>(*args)
}
