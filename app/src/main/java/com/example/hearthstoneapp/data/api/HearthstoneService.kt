package com.example.hearthstoneapp.data.api

import com.example.hearthstoneapp.data.model.AllCards
import com.example.hearthstoneapp.data.model.Basic
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface HearthstoneService {
    @GET("cards")
    fun getAllCards() : Call<Basic>
}