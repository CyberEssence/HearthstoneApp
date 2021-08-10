package com.example.hearthstoneapp.data.repository.allcards.datasource

import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic

interface AllCardsLocalDataSource {
    suspend fun getAllCardsFromDB(): List<AllCardsBasic>
    suspend fun saveAllCardsToDB(allCardBasics: List<AllCardsBasic>)
    suspend fun clearAll()
}