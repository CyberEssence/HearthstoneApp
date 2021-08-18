package com.example.hearthstoneapp.data.repository.halloffame.datasource

import com.example.hearthstoneapp.data.model.allcards.halloffame.HallOfFame
import retrofit2.Response

interface AllCardsHallOfFameRemoteDataSource {
    suspend fun getAllCardsHallOfFame(): Response<HallOfFame>
}