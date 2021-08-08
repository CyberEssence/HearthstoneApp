package com.example.hearthstoneapp.data.repository.allcards.datasource

import com.example.hearthstoneapp.data.model.AllCards

interface AllCardsCacheDataSource {
    suspend fun getAllCardsFromCache(): List<AllCards>
    suspend fun saveAllCardsToCache(allCards: List<AllCards>)
}