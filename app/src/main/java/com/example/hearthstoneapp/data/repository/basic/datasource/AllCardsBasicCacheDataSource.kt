package com.example.hearthstoneapp.data.repository.basic.datasource

import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic

interface AllCardsBasicCacheDataSource {
    suspend fun getAllCardsBasicFromCache(): List<AllCardsBasic>
    suspend fun saveAllCardsBasicToCache(allCardBasics: List<AllCardsBasic>)
}