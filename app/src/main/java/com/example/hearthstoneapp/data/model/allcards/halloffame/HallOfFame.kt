package com.example.hearthstoneapp.data.model.allcards.halloffame

import com.google.gson.annotations.SerializedName

data class HallOfFame(
    @SerializedName("Hall of Fame")
    val hallOfFame: List<AllCardsHallOfFame>
)