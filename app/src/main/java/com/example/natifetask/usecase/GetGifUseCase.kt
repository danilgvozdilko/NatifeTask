package com.example.natifetask.usecase

import com.example.natifetask.data.Gif
import com.example.natifetask.interfaces.GetGifApi
import javax.inject.Inject

class GetGifUseCase @Inject constructor(private val getGifApi: GetGifApi) {
    suspend fun getGif(limit: Int): Gif? {
        getGifApi.getGif(limit).fold(onSuccess = { result ->
            return@getGif result
        }, onFailure = { error ->
            error.printStackTrace()
        })
        return null
    }

}