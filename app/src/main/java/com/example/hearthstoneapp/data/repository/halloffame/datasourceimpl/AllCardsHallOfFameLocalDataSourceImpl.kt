package com.example.hearthstoneapp.data.repository.halloffame.datasourceimpl

import com.example.hearthstoneapp.data.db.allcards.classic.AllCardsClassicDao
import com.example.hearthstoneapp.data.db.allcards.halloffame.AllCardsHallOfFameDao
import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic
import com.example.hearthstoneapp.data.model.allcards.halloffame.AllCardsHallOfFame
import com.example.hearthstoneapp.data.repository.classic.datasource.AllCardsClassicLocalDataSource
import com.example.hearthstoneapp.data.repository.halloffame.datasource.AllCardsHallOfFameLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllCardsHallOfFameLocalDataSourceImpl(
    private val allCardsHallOfFameDao: AllCardsHallOfFameDao
) : AllCardsHallOfFameLocalDataSource {
    override suspend fun getAllCardsHallOfFameFromDB(): List<AllCardsHallOfFame> {
        return allCardsHallOfFameDao.getAllCards()
    }

    override suspend fun saveAllCardsHallOfFameToDB(allCardHallOfFame: List<AllCardsHallOfFame>) {
        CoroutineScope(Dispatchers.IO).launch {
            allCardsHallOfFameDao.saveAllCards(allCardHallOfFame)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            allCardsHallOfFameDao.deleteAllCards()
        }
    }
}