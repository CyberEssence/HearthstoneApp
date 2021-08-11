package com.example.hearthstoneapp.data.model.allcards.classic

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

@Entity(tableName = "all_cards_classic")
data class AllCardsClassic(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    var id: Int,
    @SerializedName("cardId")
    val cardId: String,
    @SerializedName("cardSet")
    val cardSet: String,
    @SerializedName("dbfId")
    val dbfId: String,
    @SerializedName("locale")
    val locale: String,
    /*@SerializedName("mechanics")
    @Nullable
    val mechanics: List<Mechanic>,*/
    @SerializedName("name")
    val name: String,
    @SerializedName("playerClass")
    val playerClass: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("faction")
    @Nullable
    val faction: String,
    @SerializedName("rarity")
    @Nullable
    val rarity: String,
    @SerializedName("cost")
    @Nullable
    val cost: Int,
    @SerializedName("attack")
    @Nullable
    val attack: Int,
    @SerializedName("health")
    @Nullable
    val health: Int,
    @SerializedName("race")
    @Nullable
    val race: String,
    @SerializedName("img")
    @Nullable
    val img: String,
    @SerializedName("imgGold")
    @Nullable
    val imgGold: String,
    @SerializedName("flavor")
    @Nullable
    val flavor: String,
    @SerializedName("artist")
    @Nullable
    val artist: String,
    @SerializedName("collectible")
    @Nullable
    val collectible: String,
    @SerializedName("spellSchool")
    @Nullable
    val spellSchool: String,
    @SerializedName("durability")
    @Nullable
    val durability: String
)