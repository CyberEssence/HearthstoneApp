package com.example.hearthstoneapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.hearthstoneapp.data.db.allcards.basic.AllCardsBasicDao
import com.example.hearthstoneapp.data.db.HearthstoneDatabase
import com.example.hearthstoneapp.data.db.allcards.classic.AllCardsClassicDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideAllCardsBasicDataBase(context: Context):HearthstoneDatabase {
        return Room.databaseBuilder(context, HearthstoneDatabase::class.java,"hearthstone")
            .fallbackToDestructiveMigration()
            .build()
    }
    @Singleton
    @Provides
    fun provideAllCardsBasicDao(hearthstoneDatabase: HearthstoneDatabase): AllCardsBasicDao {
        return hearthstoneDatabase.allCardsBasicDao()
    }

    @Singleton
    @Provides
    fun provideAllCardsClassicDao(hearthstoneDatabase: HearthstoneDatabase): AllCardsClassicDao {
        return hearthstoneDatabase.allCardsClassicDao()
    }
}