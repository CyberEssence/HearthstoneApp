package com.example.hearthstoneapp.data.repository.halloffame

import android.util.Log
import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic
import com.example.hearthstoneapp.data.model.allcards.halloffame.AllCardsHallOfFame
import com.example.hearthstoneapp.data.repository.classic.datasource.AllCardsClassicCacheDataSource
import com.example.hearthstoneapp.data.repository.classic.datasource.AllCardsClassicLocalDataSource
import com.example.hearthstoneapp.data.repository.classic.datasource.AllCardsClassicRemoteDataSource
import com.example.hearthstoneapp.data.repository.halloffame.datasource.AllCardsHallOfFameCacheDataSource
import com.example.hearthstoneapp.data.repository.halloffame.datasource.AllCardsHallOfFameLocalDataSource
import com.example.hearthstoneapp.data.repository.halloffame.datasource.AllCardsHallOfFameRemoteDataSource
import com.example.hearthstoneapp.domain.repository.classic.AllCardsClassicRepository
import com.example.hearthstoneapp.domain.repository.halloffame.AllCardsHallOfFameRepository

class AllCardsHallOfFameRepositoryImpl(
    private val allCardsHallOfFameRemoteDatasource: AllCardsHallOfFameRemoteDataSource,
    private val allCardsHallOfFameLocalDataSource: AllCardsHallOfFameLocalDataSource,
    private val allCardsHallOfFameCacheDataSource: AllCardsHallOfFameCacheDataSource
) : AllCardsHallOfFameRepository {
    override suspend fun getAllCardsHallOfFame(): List<AllCardsHallOfFame> {
        return getAllCardsHallOfFameFromCache()
    }

    override suspend fun updateAllCardsHallOfFame(): List<AllCardsHallOfFame> {
        val newListOfCard = getAllCardsHallOfFameFromAPI()
        allCardsHallOfFameLocalDataSource.clearAll()
        allCardsHallOfFameLocalDataSource.saveAllCardsHallOfFameToDB(newListOfCard)
        allCardsHallOfFameCacheDataSource.saveAllCardsHallOfFameToCache(newListOfCard)
        return newListOfCard
    }

    suspend fun getAllCardsHallOfFameFromAPI(): List<AllCardsHallOfFame> {
        var cardList: List<AllCardsHallOfFame> = listOf()
        try {
            val response = allCardsHallOfFameRemoteDatasource.getAllCardsHallOfFame()
            val body = response.body()
            if(body!=null){
                cardList = body.hallOfFame
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return cardList
    }

    suspend fun getAllCardsHallOfFameFromDB():List<AllCardsHallOfFame>{
        var cardList: List<AllCardsHallOfFame> = listOf()
        try {
            cardList = allCardsHallOfFameLocalDataSource.getAllCardsHallOfFameFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(cardList.size>0){
            return cardList
        }else{
            cardList = getAllCardsHallOfFameFromAPI()
            allCardsHallOfFameLocalDataSource.saveAllCardsHallOfFameToDB(cardList)
        }

        return cardList
    }

    suspend fun getAllCardsHallOfFameFromCache():List<AllCardsHallOfFame>{
        var cardList: List<AllCardsHallOfFame> = listOf()
        try {
            cardList = allCardsHallOfFameCacheDataSource.getAllCardsHallOfFameFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(cardList.isNotEmpty()){
            return cardList
        }else{
            cardList = getAllCardsHallOfFameFromDB()
            allCardsHallOfFameCacheDataSource.saveAllCardsHallOfFameToCache(cardList)
        }

        return cardList
    }

}