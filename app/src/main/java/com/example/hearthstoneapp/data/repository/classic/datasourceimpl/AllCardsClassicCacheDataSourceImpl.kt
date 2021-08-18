package com.example.hearthstoneapp.data.repository.classic.datasourceimpl

import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic
import com.example.hearthstoneapp.data.repository.classic.datasource.AllCardsClassicCacheDataSource

class AllCardsClassicCacheDataSourceImpl: AllCardsClassicCacheDataSource {
    private var allCardsClassicList = ArrayList<AllCardsClassic>()

    override suspend fun getAllCardsClassicFromCache(): List<AllCardsClassic> {
        return allCardsClassicList
    }

    override suspend fun saveAllCardsClassicToCache(allCardClassic: List<AllCardsClassic>) {
        allCardsClassicList.clear()
        allCardsClassicList = ArrayList(allCardClassic)
    }
}