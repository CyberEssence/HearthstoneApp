package com.example.hearthstoneapp.data.repository.allcards.datasourceimpl

import com.example.hearthstoneapp.data.api.HearthstoneService
import com.example.hearthstoneapp.data.model.Basic
import com.example.hearthstoneapp.data.repository.allcards.datasource.AllCardsRemoteDataSource
import retrofit2.Response

class AllCardsRemoteDataSourceImpl(
    private val hearthstoneService: HearthstoneService
): AllCardsRemoteDataSource {
    override suspend fun getAllCards()
            : Response<Basic> = hearthstoneService.getAllCards() as Response<Basic>

}