package com.example.hearthstoneapp.presentation.di.core

import com.example.hearthstoneapp.data.repository.allcards.datasource.AllCardsCacheDataSource
import com.example.hearthstoneapp.data.repository.allcards.datasourceimpl.AllCardsCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideAllCardsCacheDataSource(): AllCardsCacheDataSource {
        return AllCardsCacheDataSourceImpl()
    }
}