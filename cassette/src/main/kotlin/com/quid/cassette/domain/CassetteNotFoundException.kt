package com.quid.cassette.domain

class CassetteNotFoundException(msg: String = "카세트 정보를 찾을 수 없습니다.") : RuntimeException(msg)
