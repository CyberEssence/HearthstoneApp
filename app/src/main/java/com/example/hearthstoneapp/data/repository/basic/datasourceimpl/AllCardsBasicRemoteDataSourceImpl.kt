package com.example.hearthstoneapp.data.repository.basic.datasourceimpl

import com.example.hearthstoneapp.data.api.HearthstoneService
import com.example.hearthstoneapp.data.model.allcards.basic.Basic
import com.example.hearthstoneapp.data.repository.basic.datasource.AllCardsBasicRemoteDataSource
import retrofit2.Response

class AllCardsBasicRemoteDataSourceImpl(
    private val hearthstoneService: HearthstoneService
) : AllCardsBasicRemoteDataSource {
    override suspend fun getAllCardsBasic(): Response<Basic> = hearthstoneService.getAllCardsBasic()

}