package com.example.hearthstoneapp.data.repository.classic.datasource

import com.example.hearthstoneapp.data.model.allcards.basic.Basic
import com.example.hearthstoneapp.data.model.allcards.classic.Classic
import retrofit2.Response

interface AllCardsClassicRemoteDataSource {
    suspend fun getAllCardsClassic(): Response<Classic>
}