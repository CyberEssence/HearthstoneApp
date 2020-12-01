package com.example.hearthstoneapp.model.info

import com.example.hearthstoneapp.model.info.*

data class Info(
    val patch: String,
    val classes: List<String>,
    val sets: List<String>,
    val standard: List<String>,
    val wild: List<String>,
    val types: List<String>,
    val qualities: List<String>,
    val factions: List<String>,
    val races: List<String>,
    val locales: Locales
)
