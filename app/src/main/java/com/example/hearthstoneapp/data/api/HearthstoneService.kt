package com.example.hearthstoneapp.data.api

import com.example.hearthstoneapp.data.model.allcards.basic.Basic
import retrofit2.Response
import retrofit2.http.GET

interface HearthstoneService {
    @GET("cards")
    suspend fun getAllCards() : Response<Basic>

}