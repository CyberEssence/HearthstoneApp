package com.example.hearthstoneapp.data.repository.allcards.datasourceimpl

import com.example.hearthstoneapp.data.db.AllCardsDao
import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.data.repository.allcards.datasource.AllCardsLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllCardsLocalDataSourceImpl(
    private val allCardsDao: AllCardsDao
    ) : AllCardsLocalDataSource {
    override suspend fun getAllCardsFromDB(): List<AllCardsBasic> {
        return allCardsDao.getAllCards()
    }

    override suspend fun saveAllCardsToDB(allCardBasics: List<AllCardsBasic>) {
        CoroutineScope(Dispatchers.IO).launch {
            allCardsDao.saveAllCards(allCardBasics)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            allCardsDao.deleteAllCards()
        }
    }
}