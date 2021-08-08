package com.example.hearthstoneapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.hearthstoneapp.data.db.AllCardsDao
import com.example.hearthstoneapp.data.db.HearthstoneDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context):HearthstoneDatabase {
        return Room.databaseBuilder(context, HearthstoneDatabase::class.java,"tmdbclient")
            .build()
    }
    @Singleton
    @Provides
    fun provideMovieDao(hearthstoneDatabase: HearthstoneDatabase): AllCardsDao {
        return hearthstoneDatabase.allCardsDao()
    }
}