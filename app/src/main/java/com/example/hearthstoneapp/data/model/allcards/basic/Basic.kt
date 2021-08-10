package com.example.hearthstoneapp.data.model.allcards.basic

import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.google.gson.annotations.SerializedName

data class Basic(
    @SerializedName("Basic")
    val basic: List<AllCardsBasic>
)