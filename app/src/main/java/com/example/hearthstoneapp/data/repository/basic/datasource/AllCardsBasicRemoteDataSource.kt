package com.example.hearthstoneapp.data.repository.basic.datasource

import com.example.hearthstoneapp.data.model.allcards.basic.Basic
import retrofit2.Response

interface AllCardsBasicRemoteDataSource {
    suspend fun getAllCardsBasic(): Response<Basic>
}