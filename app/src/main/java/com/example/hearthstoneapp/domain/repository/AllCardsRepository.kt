package com.example.hearthstoneapp.domain.repository

import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic

interface AllCardsRepository {

    suspend fun getAllCards(): List<AllCardsBasic>?
    suspend fun updateAllCards(): List<AllCardsBasic>?
}