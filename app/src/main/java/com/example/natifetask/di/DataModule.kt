package com.example.natifetask.di

import com.example.natifetask.navigation.NavigationComponentRouter
import com.example.natifetask.navigation.Router
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun provideNavigationManager(): Router = NavigationComponentRouter()

}