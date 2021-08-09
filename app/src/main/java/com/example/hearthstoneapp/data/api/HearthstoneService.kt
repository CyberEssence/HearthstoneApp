package com.example.hearthstoneapp.data.api

import com.example.hearthstoneapp.data.model.AllCards
import com.example.hearthstoneapp.data.model.Basic
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface HearthstoneService {
    @GET("cards")
    suspend fun getAllCards() : Response<Basic>

}