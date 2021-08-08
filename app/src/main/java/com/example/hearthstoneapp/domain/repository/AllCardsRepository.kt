package com.example.hearthstoneapp.domain.repository

import com.example.hearthstoneapp.data.model.AllCards

interface AllCardsRepository {
    suspend fun getAllCards():List<AllCards>?
    suspend fun updateAllCards():List<AllCards>?
}