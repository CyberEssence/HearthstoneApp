package com.example.hearthstoneapp.model.cards

import com.google.gson.annotations.SerializedName

data class Basics(
    @SerializedName("Basic")
    val Basic: List<Basic>
)

data class Basic(
    @SerializedName("cardId")
    val cardId: String,
    @SerializedName("cardSet")
    val cardSet: String,
    @SerializedName("dbfId")
    val dbfId: String,
    @SerializedName("locale")
    val locale: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("playerClass")
    val playerClass: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("type")
    val type: String
)