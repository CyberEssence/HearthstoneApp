package com.example.hearthstoneapp.data.repository.classic.datasource

import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic

interface AllCardsClassicLocalDataSource {
    suspend fun getAllCardsClassicFromDB(): List<AllCardsClassic>
    suspend fun saveAllCardsClassicToDB(allCardClassic: List<AllCardsClassic>)
    suspend fun clearAll()
}