package com.example.hearthstoneapp.presentation.di.halloffame

import com.example.hearthstoneapp.presentation.allcards.AllCardsActivity
import dagger.Subcomponent

@AllCardsHallOfFameScope
@Subcomponent(modules = [AllCardsHallOfFameModule::class])
interface AllCardsHallOfFameSubComponent {
    fun inject(allCardsActivity: AllCardsActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): AllCardsHallOfFameSubComponent
    }
}