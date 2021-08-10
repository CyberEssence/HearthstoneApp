package com.example.hearthstoneapp.data.model.allcards.classic

import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic
import com.google.gson.annotations.SerializedName

data class Classic(
    @SerializedName("Classic")
    val Classic: List<AllCardsClassic>
)