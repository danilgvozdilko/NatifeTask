package com.example.natifetask.implementation

import com.example.natifetask.constants.api_key
import com.example.natifetask.data.GifData
import com.example.natifetask.interfaces.GetGifApi
import com.example.natifetask.interfaces.GifApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class GetGifApiImpl @Inject constructor(private val gifApi: GifApi) : GetGifApi {
    override suspend fun getGif(limit: Int): Result<GifData?> {
        return suspendCoroutine { continuation ->
            val response = gifApi.trendingGifs(api_key, limit)
            response.enqueue(object : Callback<GifData> {

                override fun onResponse(call: Call<GifData>, response: Response<GifData>) {
                    val gif = response.body()
                    continuation.resume(Result.success(gif))
                }
                override fun onFailure(call: Call<GifData>, t: Throwable) {
                    continuation.resume(Result.failure(t))
                }
            })
        }
    }
}