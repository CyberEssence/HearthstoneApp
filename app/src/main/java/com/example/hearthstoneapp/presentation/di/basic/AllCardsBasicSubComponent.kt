package com.example.hearthstoneapp.presentation.di.basic

import com.example.hearthstoneapp.presentation.allcards.AllCardsBasicActivity
import dagger.Subcomponent

@AllCardsBasicScope
@Subcomponent(modules = [AllCardsBasicModule::class])
interface AllCardsBasicSubComponent {
    fun inject(allCardsActivity: AllCardsBasicActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): AllCardsBasicSubComponent
    }
}