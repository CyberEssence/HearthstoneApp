package com.example.hearthstoneapp.presentation.di.core

import com.example.hearthstoneapp.data.api.HearthstoneService
import com.example.hearthstoneapp.data.repository.allcards.datasource.AllCardsRemoteDataSource
import com.example.hearthstoneapp.data.repository.allcards.datasourceimpl.AllCardsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideAllCardsRemoteDataSource(hearthstoneService: HearthstoneService): AllCardsRemoteDataSource {
        return AllCardsRemoteDataSourceImpl(
            hearthstoneService
        )
    }
}