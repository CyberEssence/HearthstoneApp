package com.example.hearthstoneapp.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitService {

    fun getApiClient(): HearthstoneService {
        val okhttpBuilder = OkHttpClient.Builder()

        okhttpBuilder.addInterceptor{ chain ->
            val original = chain.request()

            // Request customization: add request headers
            val requestBuilder = original.newBuilder()
                .addHeader(
                    "x-rapidapi-key",
                    "0401a45eabmsh9c4b9e74c6108b2p18da99jsna4c4817ffe40"
                )
                .addHeader("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")

            val request = requestBuilder.build()
            chain.proceed(request)
        }

        return Retrofit.Builder()
            .baseUrl("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
            .client(okhttpBuilder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HearthstoneService::class.java)
    }


}