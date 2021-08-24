package com.example.hearthstoneapp.data.model.allcards.basic

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable

@Entity(tableName = "all_cards_basic")
data class AllCardsBasic(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    var id: Int,
    @SerializedName("cardId")
    val cardId: String,
    @SerializedName("cardSet")
    var cardSet: String,
    @SerializedName("cost")
    val cost: Int,
    @SerializedName("dbfId")
    val dbfId: String,
    @SerializedName("locale")
    val locale: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("playerClass")
    val playerClass: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("faction")
    @Nullable
    val faction: String = "No faction",
    @SerializedName("rarity")
    @Nullable
    val rarity: String = "No rarity"
)