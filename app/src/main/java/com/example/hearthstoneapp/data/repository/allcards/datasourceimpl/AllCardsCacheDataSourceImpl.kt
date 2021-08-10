package com.example.hearthstoneapp.data.repository.allcards.datasourceimpl

import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.data.repository.allcards.datasource.AllCardsCacheDataSource

class AllCardsCacheDataSourceImpl: AllCardsCacheDataSource {
    private var allCardsList = ArrayList<AllCardsBasic>()

    override suspend fun getAllCardsFromCache(): List<AllCardsBasic> {
        return allCardsList
    }

    override suspend fun saveAllCardsToCache(allCardBasics: List<AllCardsBasic>) {
        allCardsList.clear()
        allCardsList = ArrayList(allCardBasics)
    }
}