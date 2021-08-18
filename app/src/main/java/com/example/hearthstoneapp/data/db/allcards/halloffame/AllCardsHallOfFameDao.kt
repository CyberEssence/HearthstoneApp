package com.example.hearthstoneapp.data.db.allcards.halloffame

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hearthstoneapp.data.model.allcards.halloffame.AllCardsHallOfFame

@Dao
interface AllCardsHallOfFameDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllCards(allCardHallOfFame : List<AllCardsHallOfFame>)

    @Query("DELETE FROM all_cards_hall_of_fame")
    suspend fun deleteAllCards()

    @Query("SELECT * FROM all_cards_hall_of_fame")
    suspend fun getAllCards():List<AllCardsHallOfFame>
}