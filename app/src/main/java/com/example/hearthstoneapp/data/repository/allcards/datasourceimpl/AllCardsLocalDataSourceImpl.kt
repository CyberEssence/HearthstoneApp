package com.example.hearthstoneapp.data.repository.allcards.datasourceimpl

import com.example.hearthstoneapp.data.db.AllCardsDao
import com.example.hearthstoneapp.data.model.AllCards
import com.example.hearthstoneapp.data.repository.allcards.datasource.AllCardsLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllCardsLocalDataSourceImpl(
    private val allCardsDao: AllCardsDao
    ) : AllCardsLocalDataSource {
    override suspend fun getAllCardsFromDB(): List<AllCards> {
        return allCardsDao.getAllCards()
    }

    override suspend fun saveAllCardsToDB(allCards: List<AllCards>) {
        CoroutineScope(Dispatchers.IO).launch {
            allCardsDao.saveAllCards(allCards)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            allCardsDao.deleteAllCards()
        }
    }
}