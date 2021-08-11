package com.example.hearthstoneapp.data.repository.basic

import android.util.Log
import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.data.repository.basic.datasource.AllCardsBasicCacheDataSource
import com.example.hearthstoneapp.data.repository.basic.datasource.AllCardsBasicLocalDataSource
import com.example.hearthstoneapp.data.repository.basic.datasource.AllCardsBasicRemoteDataSource
import com.example.hearthstoneapp.domain.repository.basic.AllCardsBasicRepository
import java.lang.Exception

class AllCardsBasicRepositoryImpl(
    private val allCardsBasicRemoteDatasource: AllCardsBasicRemoteDataSource,
    private val allCardsBasicLocalDataSource: AllCardsBasicLocalDataSource,
    private val allCardsBasicCacheDataSource: AllCardsBasicCacheDataSource
) : AllCardsBasicRepository {
    override suspend fun getAllCardsBasic(): List<AllCardsBasic>? {
        return getAllCardsBasicFromCache()
    }

    override suspend fun updateAllCardsBasic(): List<AllCardsBasic>? {
        val newListOfCard = getAllCardsBasicFromAPI()
        allCardsBasicLocalDataSource.clearAll()
        allCardsBasicLocalDataSource.saveAllCardsBasicToDB(newListOfCard)
        allCardsBasicCacheDataSource.saveAllCardsBasicToCache(newListOfCard)
        return newListOfCard
    }

    suspend fun getAllCardsBasicFromAPI(): List<AllCardsBasic> {
        var cardList: List<AllCardsBasic> = listOf()
        try {
            val response = allCardsBasicRemoteDatasource.getAllCardsBasic()
            val body = response.body()
            if(body!=null){
                cardList = body.basic
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return cardList
    }

    suspend fun getAllCardsBasicFromDB():List<AllCardsBasic>{
        var cardList: List<AllCardsBasic> = listOf()
        try {
            cardList = allCardsBasicLocalDataSource.getAllCardsBasicFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(cardList.size>0){
            return cardList
        }else{
            cardList = getAllCardsBasicFromAPI()
            allCardsBasicLocalDataSource.saveAllCardsBasicToDB(cardList)
        }

        return cardList
    }

    suspend fun getAllCardsBasicFromCache():List<AllCardsBasic>{
        var cardList: List<AllCardsBasic> = listOf()
        try {
            cardList =allCardsBasicCacheDataSource.getAllCardsBasicFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(cardList.size>0){
            return cardList
        }else{
            cardList = getAllCardsBasicFromDB()
            allCardsBasicCacheDataSource.saveAllCardsBasicToCache(cardList)
        }

        return cardList
    }

}