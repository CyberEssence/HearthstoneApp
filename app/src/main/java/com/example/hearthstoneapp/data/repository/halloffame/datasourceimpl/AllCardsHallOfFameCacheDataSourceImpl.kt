package com.example.hearthstoneapp.data.repository.halloffame.datasourceimpl

import com.example.hearthstoneapp.data.model.allcards.halloffame.AllCardsHallOfFame
import com.example.hearthstoneapp.data.repository.halloffame.datasource.AllCardsHallOfFameCacheDataSource

class AllCardsHallOfFameCacheDataSourceImpl: AllCardsHallOfFameCacheDataSource {
    private var allCardsHallOfFameList = ArrayList<AllCardsHallOfFame>()

    override suspend fun getAllCardsHallOfFameFromCache(): List<AllCardsHallOfFame> {
        return allCardsHallOfFameList
    }

    override suspend fun saveAllCardsHallOfFameToCache(allCardHallOfFame: List<AllCardsHallOfFame>) {
        allCardsHallOfFameList.clear()
        allCardsHallOfFameList = ArrayList(allCardHallOfFame)
    }
}