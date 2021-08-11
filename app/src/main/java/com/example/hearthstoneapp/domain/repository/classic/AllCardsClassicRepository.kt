package com.example.hearthstoneapp.domain.repository.classic

import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic

interface AllCardsClassicRepository {

    suspend fun getAllCardsClassic(): List<AllCardsClassic>?
    suspend fun updateAllCardsClassic(): List<AllCardsClassic>?
}