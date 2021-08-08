package com.example.hearthstoneapp.presentation.di

import com.example.hearthstoneapp.presentation.di.allcards.AllCardsSubComponent

interface Injector {
    fun createAllCardsSubComponent(): AllCardsSubComponent
}