package com.example.hearthstoneapp.data.model.allcards.classic

data class AllCardsClassic(
    val cardId: String,
    val cardSet: String,
    val dbfId: String,
    val locale: String,
    val mechanics: List<Mechanic>,
    val name: String,
    val playerClass: String,
    val text: String,
    val type: String
)