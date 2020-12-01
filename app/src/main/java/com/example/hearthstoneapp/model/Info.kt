package com.example.hearthstoneapp.model

data class Info(
    val patch: String,
    val classes: List<String>,
    val sets: List<String>,
    val standard: List<String>,
    val wild: List<String>,
    val factions: List<String>,
    val qualities: List<String>,
    val races: List<String>,
    val locales: List<String>
)
