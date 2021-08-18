package com.example.hearthstoneapp.presentation.di.core

import com.example.hearthstoneapp.data.repository.basic.AllCardsBasicRepositoryImpl
import com.example.hearthstoneapp.data.repository.basic.datasource.AllCardsBasicCacheDataSource
import com.example.hearthstoneapp.data.repository.basic.datasource.AllCardsBasicLocalDataSource
import com.example.hearthstoneapp.data.repository.basic.datasource.AllCardsBasicRemoteDataSource
import com.example.hearthstoneapp.data.repository.classic.AllCardsClassicRepositoryImpl
import com.example.hearthstoneapp.data.repository.classic.datasource.AllCardsClassicCacheDataSource
import com.example.hearthstoneapp.data.repository.classic.datasource.AllCardsClassicLocalDataSource
import com.example.hearthstoneapp.data.repository.classic.datasource.AllCardsClassicRemoteDataSource
import com.example.hearthstoneapp.data.repository.halloffame.AllCardsHallOfFameRepositoryImpl
import com.example.hearthstoneapp.data.repository.halloffame.datasource.AllCardsHallOfFameCacheDataSource
import com.example.hearthstoneapp.data.repository.halloffame.datasource.AllCardsHallOfFameLocalDataSource
import com.example.hearthstoneapp.data.repository.halloffame.datasource.AllCardsHallOfFameRemoteDataSource
import com.example.hearthstoneapp.domain.repository.basic.AllCardsBasicRepository
import com.example.hearthstoneapp.domain.repository.classic.AllCardsClassicRepository
import com.example.hearthstoneapp.domain.repository.halloffame.AllCardsHallOfFameRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideAllCardsBasicRepository(
        allCardsBasicRemoteDatasource: AllCardsBasicRemoteDataSource,
        allCardsBasicLocalDataSource: AllCardsBasicLocalDataSource,
        allCardsBasicCacheDataSource: AllCardsBasicCacheDataSource
    ): AllCardsBasicRepository {

        return AllCardsBasicRepositoryImpl(
            allCardsBasicRemoteDatasource,
            allCardsBasicLocalDataSource,
            allCardsBasicCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideAllCardsClassicRepository(
        allCardsClassicRemoteDatasource: AllCardsClassicRemoteDataSource,
        allCardsClassicLocalDataSource: AllCardsClassicLocalDataSource,
        allCardsClassicCacheDataSource: AllCardsClassicCacheDataSource
    ): AllCardsClassicRepository {

        return AllCardsClassicRepositoryImpl(
            allCardsClassicRemoteDatasource,
            allCardsClassicLocalDataSource,
            allCardsClassicCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideAllCardsHallOfFameRepository(
        allCardsHallOfFameRemoteDatasource: AllCardsHallOfFameRemoteDataSource,
        allCardsHallOfFameLocalDataSource: AllCardsHallOfFameLocalDataSource,
        allCardsHallOfFameCacheDataSource: AllCardsHallOfFameCacheDataSource
    ): AllCardsHallOfFameRepository {

        return AllCardsHallOfFameRepositoryImpl(
            allCardsHallOfFameRemoteDatasource,
            allCardsHallOfFameLocalDataSource,
            allCardsHallOfFameCacheDataSource
        )
    }
}