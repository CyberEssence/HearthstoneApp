package com.example.hearthstoneapp.data.repository.halloffame.datasource

import com.example.hearthstoneapp.data.model.allcards.halloffame.AllCardsHallOfFame

interface AllCardsHallOfFameCacheDataSource {
    suspend fun getAllCardsHallOfFameFromCache(): List<AllCardsHallOfFame>
    suspend fun saveAllCardsHallOfFameToCache(allCardHallOfFame: List<AllCardsHallOfFame>)
}