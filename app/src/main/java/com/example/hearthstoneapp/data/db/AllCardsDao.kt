package com.example.hearthstoneapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hearthstoneapp.data.model.AllCards

@Dao
interface AllCardsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllCards(allCards : List<AllCards>)

    @Query("DELETE FROM all_cards")
    suspend fun deleteAllCards()

    @Query("SELECT * FROM all_cards")
    suspend fun getAllCards():List<AllCards>
}