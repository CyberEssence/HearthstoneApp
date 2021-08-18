package com.example.hearthstoneapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hearthstoneapp.data.db.allcards.basic.AllCardsBasicDao
import com.example.hearthstoneapp.data.db.allcards.classic.AllCardsClassicDao
import com.example.hearthstoneapp.data.db.allcards.halloffame.AllCardsHallOfFameDao
import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic
import com.example.hearthstoneapp.data.model.allcards.halloffame.AllCardsHallOfFame

@Database(entities = [AllCardsBasic::class, AllCardsClassic::class, AllCardsHallOfFame::class],
version = 9,
exportSchema = false)
abstract class HearthstoneDatabase: RoomDatabase() {
    abstract fun allCardsBasicDao(): AllCardsBasicDao
    abstract fun allCardsClassicDao(): AllCardsClassicDao
    abstract fun allCardsHallOfFameDao(): AllCardsHallOfFameDao
}