package com.example.hearthstoneapp.presentation.di.core

import com.example.hearthstoneapp.data.api.HearthstoneService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String) {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {

        val okHttpBuilder = OkHttpClient.Builder()
        okHttpBuilder.connectTimeout(5, TimeUnit.MINUTES) // connect timeout
            .writeTimeout(5, TimeUnit.MINUTES) // write timeout
            .readTimeout(5, TimeUnit.MINUTES) // read timeout

        okHttpBuilder.addInterceptor{ chain ->
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
            .client(okHttpBuilder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideHearthstoneService(retrofit: Retrofit): HearthstoneService {
        return retrofit.create(HearthstoneService::class.java)
    }
}