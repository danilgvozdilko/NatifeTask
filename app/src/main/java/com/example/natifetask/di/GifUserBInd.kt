package com.example.natifetask.di

import com.example.natifetask.implementation.GetGifApiImpl
import com.example.natifetask.interfaces.GetGifApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class GifUserBInd {

    @Binds
    abstract fun bindNetwork(impl: GetGifApiImpl): GetGifApi

}