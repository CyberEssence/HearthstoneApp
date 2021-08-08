package com.example.hearthstoneapp.presentation.di.core

import com.example.hearthstoneapp.data.repository.allcards.AllCardsRepositoryImpl
import com.example.hearthstoneapp.data.repository.allcards.datasource.AllCardsCacheDataSource
import com.example.hearthstoneapp.data.repository.allcards.datasource.AllCardsLocalDataSource
import com.example.hearthstoneapp.data.repository.allcards.datasource.AllCardsRemoteDataSource
import com.example.hearthstoneapp.domain.repository.AllCardsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideAllCardsRepository(
        allCardsRemoteDatasource: AllCardsRemoteDataSource,
        allCardsLocalDataSource: AllCardsLocalDataSource,
        allCardsCacheDataSource: AllCardsCacheDataSource
    ): AllCardsRepository {

        return AllCardsRepositoryImpl(
            allCardsRemoteDatasource,
            allCardsLocalDataSource,
            allCardsCacheDataSource
        )


    }
}