package com.example.hearthstoneapp.domain.repository.basic

import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic

interface AllCardsBasicRepository {

    suspend fun getAllCardsBasic(): List<AllCardsBasic>?
    suspend fun updateAllCardsBasic(): List<AllCardsBasic>?
}