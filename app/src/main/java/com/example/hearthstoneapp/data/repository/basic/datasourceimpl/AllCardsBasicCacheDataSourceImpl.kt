package com.example.hearthstoneapp.data.repository.basic.datasourceimpl

import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.data.repository.basic.datasource.AllCardsBasicCacheDataSource

class AllCardsBasicCacheDataSourceImpl: AllCardsBasicCacheDataSource {
    private var allCardsList = ArrayList<AllCardsBasic>()

    override suspend fun getAllCardsBasicFromCache(): List<AllCardsBasic> {
        return allCardsList
    }

    override suspend fun saveAllCardsBasicToCache(allCardBasics: List<AllCardsBasic>) {
        allCardsList.clear()
        allCardsList = ArrayList(allCardBasics)
    }
}