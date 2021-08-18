package com.example.hearthstoneapp.presentation.di.core

import com.example.hearthstoneapp.data.api.HearthstoneService
import com.example.hearthstoneapp.data.repository.basic.datasource.AllCardsBasicRemoteDataSource
import com.example.hearthstoneapp.data.repository.basic.datasourceimpl.AllCardsBasicRemoteDataSourceImpl
import com.example.hearthstoneapp.data.repository.classic.datasource.AllCardsClassicRemoteDataSource
import com.example.hearthstoneapp.data.repository.classic.datasourceimpl.AllCardsClassicRemoteDataSourceImpl
import com.example.hearthstoneapp.data.repository.halloffame.datasource.AllCardsHallOfFameRemoteDataSource
import com.example.hearthstoneapp.data.repository.halloffame.datasourceimpl.AllCardsHallOfFameRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideAllCardsBasicRemoteDataSource(hearthstoneService: HearthstoneService): AllCardsBasicRemoteDataSource {
        return AllCardsBasicRemoteDataSourceImpl(
            hearthstoneService
        )
    }

    @Singleton
    @Provides
    fun provideAllCardsClassicRemoteDataSource(hearthstoneService: HearthstoneService): AllCardsClassicRemoteDataSource {
        return AllCardsClassicRemoteDataSourceImpl(
            hearthstoneService
        )
    }

    @Singleton
    @Provides
    fun provideAllCardsHallOfFameRemoteDataSource(hearthstoneService: HearthstoneService): AllCardsHallOfFameRemoteDataSource {
        return AllCardsHallOfFameRemoteDataSourceImpl(
            hearthstoneService
        )
    }
}