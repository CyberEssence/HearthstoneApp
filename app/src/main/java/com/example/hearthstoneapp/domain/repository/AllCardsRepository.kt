package com.example.hearthstoneapp.domain.repository

import android.util.Log
import com.example.hearthstoneapp.data.model.AllCards
import com.example.hearthstoneapp.data.repository.allcards.datasource.AllCardsCacheDataSource
import com.example.hearthstoneapp.data.repository.allcards.datasource.AllCardsLocalDataSource
import com.example.hearthstoneapp.data.repository.allcards.datasource.AllCardsRemoteDataSource
import java.lang.Exception

interface AllCardsRepository {

    suspend fun getAllCards(): List<AllCards>?
    suspend fun updateAllCards(): List<AllCards>?
}