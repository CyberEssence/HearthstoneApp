package com.example.hearthstoneapp.presentation.di.core

import com.example.hearthstoneapp.data.api.HearthstoneService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String) {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideHearthstoneService(retrofit: Retrofit): HearthstoneService {
        return retrofit.create(HearthstoneService::class.java)
    }
}