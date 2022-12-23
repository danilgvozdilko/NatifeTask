package com.example.natifetask.interfaces

import com.example.natifetask.data.GifData

interface GetGifApi {
    suspend fun getGif(limit: Int): Result<GifData?>
}