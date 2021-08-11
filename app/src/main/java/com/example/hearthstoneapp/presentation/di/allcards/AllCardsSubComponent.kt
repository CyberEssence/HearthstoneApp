package com.example.hearthstoneapp.presentation.di.allcards

import com.example.hearthstoneapp.presentation.allcards.AllCardsActivity
import dagger.Subcomponent

@AllCardsScope
@Subcomponent(modules = [AllCardsModule::class])
interface AllCardsSubComponent {
    fun inject(allCardsActivity: AllCardsActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): AllCardsSubComponent
    }
}