package com.example.hearthstoneapp.presentation.di

import com.example.hearthstoneapp.presentation.di.basic.AllCardsBasicSubComponent
import com.example.hearthstoneapp.presentation.di.classic.AllCardsClassicSubComponent

interface Injector {
    fun createAllCardsBasicSubComponent(): AllCardsBasicSubComponent
    fun createAllCardsClassicSubComponent(): AllCardsClassicSubComponent
}