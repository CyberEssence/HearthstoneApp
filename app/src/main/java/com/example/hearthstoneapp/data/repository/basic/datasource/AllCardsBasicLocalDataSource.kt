package com.example.hearthstoneapp.data.repository.basic.datasource

import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic

interface AllCardsBasicLocalDataSource {
    suspend fun getAllCardsBasicFromDB(): List<AllCardsBasic>
    suspend fun saveAllCardsBasicToDB(allCardBasics: List<AllCardsBasic>)
    suspend fun clearAll()
}