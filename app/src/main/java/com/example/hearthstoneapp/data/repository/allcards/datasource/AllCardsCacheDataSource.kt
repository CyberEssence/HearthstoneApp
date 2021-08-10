package com.example.hearthstoneapp.data.repository.allcards.datasource

import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic

interface AllCardsCacheDataSource {
    suspend fun getAllCardsFromCache(): List<AllCardsBasic>
    suspend fun saveAllCardsToCache(allCardBasics: List<AllCardsBasic>)
}