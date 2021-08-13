package com.example.hearthstoneapp.presentation.di.allcards

import com.example.hearthstoneapp.presentation.allcards.AllCardsBasicActivity
import dagger.Subcomponent

@AllCardsScope
@Subcomponent(modules = [AllCardsModule::class])
interface AllCardsSubComponent {
    fun inject(allCardsActivity: AllCardsBasicActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): AllCardsSubComponent
    }
}