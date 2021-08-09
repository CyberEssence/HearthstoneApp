package com.example.hearthstoneapp.data.repository.allcards

import android.util.Log
import com.example.hearthstoneapp.data.api.HearthstoneService
import com.example.hearthstoneapp.data.model.AllCards
import com.example.hearthstoneapp.data.repository.allcards.datasource.AllCardsCacheDataSource
import com.example.hearthstoneapp.data.repository.allcards.datasource.AllCardsLocalDataSource
import com.example.hearthstoneapp.data.repository.allcards.datasource.AllCardsRemoteDataSource
import com.example.hearthstoneapp.domain.repository.AllCardsRepository
import java.lang.Exception

class AllCardsRepositoryImpl(
    private val artistRemoteDatasource: AllCardsRemoteDataSource,
    private val artistLocalDataSource: AllCardsLocalDataSource,
    private val artistCacheDataSource: AllCardsCacheDataSource
) : AllCardsRepository {
    override suspend fun getAllCards(): List<AllCards>? {
        return getAllCardsFromCache()
    }

    override suspend fun updateAllCards(): List<AllCards>? {
        val newListOfArtist = getAllCardsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveAllCardsToDB(newListOfArtist)
        artistCacheDataSource.saveAllCardsToCache(newListOfArtist)
        return newListOfArtist
    }

    suspend fun getAllCardsFromAPI(): List<AllCards> {
        var artistList: List<AllCards> = listOf()
        try {
            val response = artistRemoteDatasource.getAllCards()
            val body = response.body()
            if(body!=null){
                artistList = body.Basic
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

    suspend fun getAllCardsFromDB():List<AllCards>{
        var artistList: List<AllCards> = listOf()
        try {
            artistList = artistLocalDataSource.getAllCardsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(artistList.size>0){
            return artistList
        }else{
            artistList= getAllCardsFromAPI()
            artistLocalDataSource.saveAllCardsToDB(artistList)
        }

        return artistList
    }

    suspend fun getAllCardsFromCache():List<AllCards>{
        var artistList: List<AllCards> = listOf()
        try {
            artistList =artistCacheDataSource.getAllCardsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(artistList.size>0){
            return artistList
        }else{
            artistList=getAllCardsFromDB()
            artistCacheDataSource.saveAllCardsToCache(artistList)
        }

        return artistList
    }

}