package com.example.hearthstoneapp.model.cards

import com.google.gson.annotations.SerializedName

data class Card (
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("img")
    var img: String? = null,
    @SerializedName("imgGold")
    var imgGold: String? = null
)