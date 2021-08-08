package com.example.hearthstoneapp.data.repository.allcards.datasource

import com.example.hearthstoneapp.data.model.AllCards

interface AllCardsLocalDataSource {
    suspend fun getAllCardsFromDB(): List<AllCards>
    suspend fun saveAllCardsToDB(allCards: List<AllCards>)
    suspend fun clearAll()
}