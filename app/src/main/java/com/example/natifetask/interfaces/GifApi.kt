package com.example.natifetask.interfaces

import com.example.natifetask.data.GifData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface GifApi {
    @GET("gifs/trending")
    fun trendingGifs(@Query("api_key") api_key: String, @Query("limit") limit: Int): Call<GifData>
}