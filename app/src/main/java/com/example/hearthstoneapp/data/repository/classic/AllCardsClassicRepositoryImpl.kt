package com.example.hearthstoneapp.data.repository.classic

import android.util.Log
import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic
import com.example.hearthstoneapp.data.repository.classic.datasource.AllCardsClassicCacheDataSource
import com.example.hearthstoneapp.data.repository.classic.datasource.AllCardsClassicLocalDataSource
import com.example.hearthstoneapp.data.repository.classic.datasource.AllCardsClassicRemoteDataSource
import com.example.hearthstoneapp.domain.repository.classic.AllCardsClassicRepository
import java.lang.Exception

class AllCardsClassicRepositoryImpl(
    private val allCardsClassicRemoteDatasource: AllCardsClassicRemoteDataSource,
    private val allCardsClassicLocalDataSource: AllCardsClassicLocalDataSource,
    private val allCardsClassicCacheDataSource: AllCardsClassicCacheDataSource
) : AllCardsClassicRepository {
    override suspend fun getAllCardsClassic(): List<AllCardsClassic> {
        return getAllCardsClassicFromCache()
    }

    override suspend fun updateAllCardsClassic(): List<AllCardsClassic> {
        val newListOfCard = getAllCardsClassicFromAPI()
        allCardsClassicLocalDataSource.clearAll()
        allCardsClassicLocalDataSource.saveAllCardsClassicToDB(newListOfCard)
        allCardsClassicCacheDataSource.saveAllCardsClassicToCache(newListOfCard)
        return newListOfCard
    }

    suspend fun getAllCardsClassicFromAPI(): List<AllCardsClassic> {
        var cardList: List<AllCardsClassic> = listOf()
        try {
            val response = allCardsClassicRemoteDatasource.getAllCardsClassic()
            val body = response.body()
            if(body!=null){
                cardList = body.Classic
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return cardList
    }

    suspend fun getAllCardsClassicFromDB():List<AllCardsClassic>{
        var cardList: List<AllCardsClassic> = listOf()
        try {
            cardList = allCardsClassicLocalDataSource.getAllCardsClassicFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(cardList.size>0){
            return cardList
        }else{
            cardList = getAllCardsClassicFromAPI()
            allCardsClassicLocalDataSource.saveAllCardsClassicToDB(cardList)
        }

        return cardList
    }

    suspend fun getAllCardsClassicFromCache():List<AllCardsClassic>{
        var cardList: List<AllCardsClassic> = listOf()
        try {
            cardList = allCardsClassicCacheDataSource.getAllCardsClassicFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(cardList.size>0){
            return cardList
        }else{
            cardList = getAllCardsClassicFromDB()
            allCardsClassicCacheDataSource.saveAllCardsClassicToCache(cardList)
        }

        return cardList
    }

}