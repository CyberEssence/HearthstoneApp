package com.example.hearthstoneapp.presentation.di.classic

import com.example.hearthstoneapp.presentation.allcards.AllCardsActivity
import dagger.Subcomponent

@AllCardsClassicScope
@Subcomponent(modules = [AllCardsClassicModule::class])
interface AllCardsClassicSubComponent {
    fun inject(allCardsActivity: AllCardsActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): AllCardsClassicSubComponent
    }
}