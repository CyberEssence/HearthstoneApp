package com.example.hearthstoneapp.data.api

import com.example.hearthstoneapp.data.model.allcards.basic.Basic
import com.example.hearthstoneapp.data.model.allcards.classic.Classic
import retrofit2.Response
import retrofit2.http.GET

interface HearthstoneService {
    @GET("cards")
    suspend fun getAllCardsBasic() : Response<Basic>

    @GET("cards")
    suspend fun getAllCardsClassic() : Response<Classic>

}