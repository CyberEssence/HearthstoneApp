package com.example.hearthstoneapp.data.repository.classic.datasourceimpl

import com.example.hearthstoneapp.data.api.HearthstoneService
import com.example.hearthstoneapp.data.model.allcards.basic.Basic
import com.example.hearthstoneapp.data.model.allcards.classic.Classic
import com.example.hearthstoneapp.data.repository.basic.datasource.AllCardsBasicRemoteDataSource
import com.example.hearthstoneapp.data.repository.classic.datasource.AllCardsClassicRemoteDataSource
import retrofit2.Response

class AllCardsClassicRemoteDataSourceImpl(
    private val hearthstoneService: HearthstoneService
): AllCardsClassicRemoteDataSource {
    override suspend fun getAllCardsClassic()
            : Response<Classic> = hearthstoneService.getAllCardsClassic()

}