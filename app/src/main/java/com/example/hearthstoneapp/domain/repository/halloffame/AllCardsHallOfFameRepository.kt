package com.example.hearthstoneapp.domain.repository.halloffame

import com.example.hearthstoneapp.data.model.allcards.halloffame.AllCardsHallOfFame

interface AllCardsHallOfFameRepository {
    suspend fun getAllCardsHallOfFame(): List<AllCardsHallOfFame>?
    suspend fun updateAllCardsHallOfFame(): List<AllCardsHallOfFame>?
}