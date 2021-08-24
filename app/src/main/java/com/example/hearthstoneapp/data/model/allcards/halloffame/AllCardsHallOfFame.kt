package com.example.hearthstoneapp.data.model.allcards.halloffame

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hearthstoneapp.data.model.allcards.classic.Mechanic
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

@Entity(tableName = "all_cards_hall_of_fame")
data class AllCardsHallOfFame(
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
    val mechanics: List<Mechanic>,*/
    @SerializedName("name")
    val name: String,
    @SerializedName("playerClass")
    val playerClass: String,
    @SerializedName("text")
    val text: String = "No text",
    @SerializedName("type")
    val type: String,
    @SerializedName("faction")
    @Nullable
    val faction: String = "No faction",
    @SerializedName("rarity")
    @Nullable
    val rarity: String = "No rarity",
    @SerializedName("cost")
    @Nullable
    val cost: Int = -1,
    @SerializedName("attack")
    @Nullable
    val attack: Int = -1,
    @SerializedName("health")
    @Nullable
    val health: Int = -1,
    @SerializedName("race")
    @Nullable
    val race: String = "No race",
    @SerializedName("img")
    @Nullable
    val img: String = "No image",
    @SerializedName("imgGold")
    @Nullable
    val imgGold: String = "No image gold",
    @SerializedName("flavor")
    @Nullable
    val flavor: String = "No flavor",
    @SerializedName("artist")
    @Nullable
    val artist: String = "No artist",
    @SerializedName("collectible")
    @Nullable
    val collectible: String = "No collectible",
    @SerializedName("spellSchool")
    @Nullable
    val spellSchool: String = "Np spell school",
    @SerializedName("durability")
    @Nullable
    val durability: String = "No durability"
)