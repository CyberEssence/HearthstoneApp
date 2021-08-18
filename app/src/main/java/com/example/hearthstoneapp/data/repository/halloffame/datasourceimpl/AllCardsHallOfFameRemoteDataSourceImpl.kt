package com.example.hearthstoneapp.data.repository.halloffame.datasourceimpl

import com.example.hearthstoneapp.data.api.HearthstoneService
import com.example.hearthstoneapp.data.model.allcards.classic.Classic
import com.example.hearthstoneapp.data.model.allcards.halloffame.HallOfFame
import com.example.hearthstoneapp.data.repository.classic.datasource.AllCardsClassicRemoteDataSource
import com.example.hearthstoneapp.data.repository.halloffame.datasource.AllCardsHallOfFameRemoteDataSource
import retrofit2.Response

class AllCardsHallOfFameRemoteDataSourceImpl(
    private val hearthstoneService: HearthstoneService
): AllCardsHallOfFameRemoteDataSource {
    override suspend fun getAllCardsHallOfFame()
            : Response<HallOfFame> = hearthstoneService.getAllCardsHallOfFame()

}