package com.example.hearthstoneapp.data.repository.classic.datasourceimpl

import com.example.hearthstoneapp.data.db.allcards.basic.AllCardsBasicDao
import com.example.hearthstoneapp.data.db.allcards.classic.AllCardsClassicDao
import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic
import com.example.hearthstoneapp.data.repository.basic.datasource.AllCardsBasicLocalDataSource
import com.example.hearthstoneapp.data.repository.classic.datasource.AllCardsClassicLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllCardsClassicLocalDataSourceImpl(
    private val allCardsClassicDao: AllCardsClassicDao
    ) : AllCardsClassicLocalDataSource {
    override suspend fun getAllCardsClassicFromDB(): List<AllCardsClassic> {
        return allCardsClassicDao.getAllCards()
    }

    override suspend fun saveAllCardsClassicToDB(allCardClassic: List<AllCardsClassic>) {
        CoroutineScope(Dispatchers.IO).launch {
            allCardsClassicDao.saveAllCards(allCardClassic)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            allCardsClassicDao.deleteAllCards()
        }
    }
}