package com.example.natifetask.usecase

import com.example.natifetask.data.GifData
import com.example.natifetask.interfaces.GetGifApi
import javax.inject.Inject

class GetGifUseCase @Inject constructor(private val getGifApi: GetGifApi) {
    suspend fun getGif(limit: Int): GifData? {
        getGifApi.getGif(limit).fold(onSuccess = { result ->
            return@getGif result
        }, onFailure = { error ->
            error.printStackTrace()
        })
        return null
    }

}