package com.example.hearthstoneapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic

@Database(entities = [AllCardsBasic::class],
version = 4,
exportSchema = false)
abstract class HearthstoneDatabase: RoomDatabase() {
    abstract fun allCardsDao(): AllCardsDao
}