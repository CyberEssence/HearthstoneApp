package com.example.hearthstoneapp.model.cards

import com.google.gson.annotations.SerializedName

data class Cards (
    @SerializedName("cards")
    var cards: List<Basics>
)