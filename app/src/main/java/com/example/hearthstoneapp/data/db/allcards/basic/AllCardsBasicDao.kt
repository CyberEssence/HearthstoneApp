package com.example.hearthstoneapp.data.db.allcards.basic

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic

@Dao
interface AllCardsBasicDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllCards(allCardBasics : List<AllCardsBasic>)

    @Query("DELETE FROM all_cards_basic")
    suspend fun deleteAllCards()

    @Query("SELECT * FROM all_cards_basic")
    suspend fun getAllCards():List<AllCardsBasic>
}