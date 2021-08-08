package com.example.hearthstoneapp.data.model

import com.google.gson.annotations.SerializedName

data class Basic(
    @SerializedName("Basic")
    val Basic: List<AllCards>
)