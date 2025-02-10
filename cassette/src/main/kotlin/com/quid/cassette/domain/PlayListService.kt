package com.quid.cassette.domain

import com.quid.cassette.application.dto.AddPlayListDto

interface PlayListService {
    fun addPlayList(dto: List<AddPlayListDto>)
    fun removePlayList(playList: List<Long>)
}
