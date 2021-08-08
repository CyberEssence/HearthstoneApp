package com.example.hearthstoneapp.data.repository.allcards

import android.util.Log
import com.example.hearthstoneapp.data.model.AllCards
import com.example.hearthstoneapp.data.repository.allcards.datasource.AllCardsCacheDataSource
import com.example.hearthstoneapp.data.repository.allcards.datasource.AllCardsLocalDataSource
import com.example.hearthstoneapp.data.repository.allcards.datasource.AllCardsRemoteDataSource
import com.example.hearthstoneapp.domain.repository.AllCardsRepository
import java.lang.Exception

class AllCardsRepositoryImpl(
    private val allCardsRemoteDatasource: AllCardsRemoteDataSource,
    private val allCardsLocalDataSource: AllCardsLocalDataSource,
    private val allCardsCacheDataSource: AllCardsCacheDataSource
): AllCardsRepository {

    override suspend fun getAllCards(): List<AllCards>? {
        return getAllCardsFromCache()
    }

    override suspend fun updateAllCards(): List<AllCards>? {
        val newListOfAllCards = getAllCardsFromAPI()
        allCardsLocalDataSource.clearAll()
        allCardsLocalDataSource.saveAllCardsToDB(newListOfAllCards)
        allCardsCacheDataSource.saveAllCardsToCache(newListOfAllCards)
        return newListOfAllCards
    }

    suspend fun getAllCardsFromAPI(): List<AllCards> {
        lateinit var allCardsList: List<AllCards>
        try {
            val response = allCardsRemoteDatasource.getAllCards()
            val body = response.body()
            if(body!=null){
                allCardsList = body.Basic
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return allCardsList
    }

    suspend fun getAllCardsFromDB():List<AllCards>{
        lateinit var allCardsList: List<AllCards>
        try {
            allCardsList = allCardsLocalDataSource.getAllCardsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(allCardsList.isNotEmpty()){
            return allCardsList
        }else{
            allCardsList = getAllCardsFromAPI()
            allCardsLocalDataSource.saveAllCardsToDB(allCardsList)
        }

        return allCardsList
    }

    suspend fun getAllCardsFromCache():List<AllCards>{
        lateinit var allCardsList: List<AllCards>
        try {
            allCardsList = allCardsCacheDataSource.getAllCardsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(allCardsList.isNotEmpty()){
            return allCardsList
        }else{
            allCardsList = getAllCardsFromDB()
            allCardsCacheDataSource.saveAllCardsToCache(allCardsList)
        }

        return allCardsList
    }


}