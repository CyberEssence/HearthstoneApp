package com.example.hearthstoneapp.data.repository.allcards.datasource

import com.example.hearthstoneapp.data.model.allcards.basic.Basic
import retrofit2.Response

interface AllCardsRemoteDataSource {
    suspend fun getAllCards(): Response<Basic>
}