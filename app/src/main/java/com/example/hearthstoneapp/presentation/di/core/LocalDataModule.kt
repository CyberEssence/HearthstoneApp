package com.example.hearthstoneapp.presentation.di.core

import com.example.hearthstoneapp.data.db.AllCardsDao
import com.example.hearthstoneapp.data.repository.allcards.datasource.AllCardsLocalDataSource
import com.example.hearthstoneapp.data.repository.allcards.datasourceimpl.AllCardsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideAllCardsLocalDataSource(allCardsDao: AllCardsDao): AllCardsLocalDataSource{
        return AllCardsLocalDataSourceImpl(allCardsDao)
    }
}