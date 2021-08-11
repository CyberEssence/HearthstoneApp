package com.example.hearthstoneapp.data.repository.classic.datasource

import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic

interface AllCardsClassicCacheDataSource {
    suspend fun getAllCardsClassicFromCache(): List<AllCardsClassic>
    suspend fun saveAllCardsClassicToCache(allCardClassic: List<AllCardsClassic>)
}