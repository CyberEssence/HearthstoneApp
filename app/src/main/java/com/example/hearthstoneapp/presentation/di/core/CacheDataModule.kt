package com.example.hearthstoneapp.presentation.di.core

import com.example.hearthstoneapp.data.repository.basic.datasource.AllCardsBasicCacheDataSource
import com.example.hearthstoneapp.data.repository.basic.datasourceimpl.AllCardsBasicCacheDataSourceImpl
import com.example.hearthstoneapp.data.repository.classic.datasource.AllCardsClassicCacheDataSource
import com.example.hearthstoneapp.data.repository.classic.datasourceimpl.AllCardsClassicCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideAllCardsBasicCacheDataSource(): AllCardsBasicCacheDataSource {
        return AllCardsBasicCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideAllCardsClassicCacheDataSource(): AllCardsClassicCacheDataSource {
        return AllCardsClassicCacheDataSourceImpl()
    }
}