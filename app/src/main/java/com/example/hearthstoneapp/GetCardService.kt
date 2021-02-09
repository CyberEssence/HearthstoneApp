package com.example.hearthstoneapp

import com.example.hearthstoneapp.model.cards.Basics
import com.example.hearthstoneapp.model.cards.Card
import com.example.hearthstoneapp.model.cards.Cards
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GetCardService {
    @GET("cards")
    fun getAllCards() : Call<Basics>
}