package com.example.hearthstoneapp.presentation.di.core

import com.example.hearthstoneapp.data.db.allcards.basic.AllCardsBasicDao
import com.example.hearthstoneapp.data.db.allcards.classic.AllCardsClassicDao
import com.example.hearthstoneapp.data.db.allcards.halloffame.AllCardsHallOfFameDao
import com.example.hearthstoneapp.data.repository.basic.datasource.AllCardsBasicLocalDataSource
import com.example.hearthstoneapp.data.repository.basic.datasourceimpl.AllCardsBasicLocalDataSourceImpl
import com.example.hearthstoneapp.data.repository.classic.datasource.AllCardsClassicLocalDataSource
import com.example.hearthstoneapp.data.repository.classic.datasourceimpl.AllCardsClassicLocalDataSourceImpl
import com.example.hearthstoneapp.data.repository.halloffame.datasource.AllCardsHallOfFameLocalDataSource
import com.example.hearthstoneapp.data.repository.halloffame.datasourceimpl.AllCardsHallOfFameLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideAllCardsBasicLocalDataSource(allCardsBasicDao: AllCardsBasicDao): AllCardsBasicLocalDataSource{
        return AllCardsBasicLocalDataSourceImpl(allCardsBasicDao)
    }

    @Singleton
    @Provides
    fun provideAllCardsClassicLocalDataSource(allCardsClassicDao: AllCardsClassicDao): AllCardsClassicLocalDataSource{
        return AllCardsClassicLocalDataSourceImpl(allCardsClassicDao)
    }

    @Singleton
    @Provides
    fun provideAllCardsHallOfFameLocalDataSource(allCardsHallOfFameDao: AllCardsHallOfFameDao): AllCardsHallOfFameLocalDataSource {
        return AllCardsHallOfFameLocalDataSourceImpl(allCardsHallOfFameDao)
    }
}