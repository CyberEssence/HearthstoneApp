package com.example.hearthstoneapp.presentation.di.basic

import com.example.hearthstoneapp.presentation.allcards.AllCardsActivity
import dagger.Subcomponent

@AllCardsBasicScope
@Subcomponent(modules = [AllCardsBasicModule::class])
interface AllCardsBasicSubComponent {
    fun inject(allCardsActivity: AllCardsActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): AllCardsBasicSubComponent
    }
}