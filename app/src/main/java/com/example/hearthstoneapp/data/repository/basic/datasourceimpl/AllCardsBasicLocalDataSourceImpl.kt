package com.example.hearthstoneapp.data.repository.basic.datasourceimpl

import com.example.hearthstoneapp.data.db.allcards.basic.AllCardsBasicDao
import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.data.repository.basic.datasource.AllCardsBasicLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllCardsBasicLocalDataSourceImpl(
    private val allCardsBasicDao: AllCardsBasicDao
    ) : AllCardsBasicLocalDataSource {
    override suspend fun getAllCardsBasicFromDB(): List<AllCardsBasic> {
        return allCardsBasicDao.getAllCards()
    }

    override suspend fun saveAllCardsBasicToDB(allCardBasics: List<AllCardsBasic>) {
        CoroutineScope(Dispatchers.IO).launch {
            allCardsBasicDao.saveAllCards(allCardBasics)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            allCardsBasicDao.deleteAllCards()
        }
    }
}