package com.example.hearthstoneapp.data.db.allcards.classic

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic

@Dao
interface AllCardsClassicDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllCards(allCardBasics : List<AllCardsClassic>)

    @Query("DELETE FROM all_cards_classic")
    suspend fun deleteAllCards()

    @Query("SELECT * FROM all_cards_classic")
    suspend fun getAllCards():List<AllCardsClassic>
}