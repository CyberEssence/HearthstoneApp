package com.example.hearthstoneapp.presentation.di.classic

import com.example.hearthstoneapp.presentation.allcards.AllCardsBasicActivity
import dagger.Subcomponent

@AllCardsClassicScope
@Subcomponent(modules = [AllCardsClassicModule::class])
interface AllCardsClassicSubComponent {
    fun inject(allCardsActivity: AllCardsBasicActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): AllCardsClassicSubComponent
    }
}