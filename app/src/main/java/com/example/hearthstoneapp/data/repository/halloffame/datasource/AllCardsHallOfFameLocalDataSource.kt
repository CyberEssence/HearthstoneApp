package com.example.hearthstoneapp.data.repository.halloffame.datasource

import com.example.hearthstoneapp.data.model.allcards.halloffame.AllCardsHallOfFame

interface AllCardsHallOfFameLocalDataSource {
    suspend fun getAllCardsHallOfFameFromDB(): List<AllCardsHallOfFame>
    suspend fun saveAllCardsHallOfFameToDB(allCardHallOfFame: List<AllCardsHallOfFame>)
    suspend fun clearAll()
}