package com.example.hearthstoneapp.data.repository.allcards.datasourceimpl

import com.example.hearthstoneapp.data.model.AllCards
import com.example.hearthstoneapp.data.repository.allcards.datasource.AllCardsCacheDataSource

class AllCardsCacheDataSourceImpl: AllCardsCacheDataSource {
    private var allCardsList = ArrayList<AllCards>()

    override suspend fun getAllCardsFromCache(): List<AllCards> {
        return allCardsList
    }

    override suspend fun saveAllCardsToCache(allCards: List<AllCards>) {
        allCardsList.clear()
        allCardsList = ArrayList(allCards)
    }
}