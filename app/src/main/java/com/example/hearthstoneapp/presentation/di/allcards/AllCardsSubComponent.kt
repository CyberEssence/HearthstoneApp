package com.example.hearthstoneapp.presentation.di.allcards

import com.example.hearthstoneapp.presentation.allcards.AllCardsActivity
import dagger.Subcomponent

@AllCardsScope
@Subcomponent(modules = [AllCardModule::class])
interface AllCardsSubComponent {
    fun inject(artistActivity: AllCardsActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): AllCardsSubComponent
    }
}