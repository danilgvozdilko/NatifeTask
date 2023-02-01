package com.example.natifetask.interfaces

import com.example.natifetask.data.Gif

interface GetGifApi {
    suspend fun getGif(limit: Int): Result<Gif?>
}