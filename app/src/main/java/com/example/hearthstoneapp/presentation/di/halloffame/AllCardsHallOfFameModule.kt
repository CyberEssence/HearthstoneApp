package com.example.hearthstoneapp.presentation.di.halloffame

import com.example.hearthstoneapp.domain.usecase.GetAllCardsUseCase
import com.example.hearthstoneapp.domain.usecase.UpdateAllCardsUseCase
import com.example.hearthstoneapp.presentation.allcards.classic.viewmodel.AllCardsClassicViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AllCardsHallOfFameModule {
    @AllCardsHallOfFameScope
    @Provides
    fun provideAllCardsHallOfFameViewModelFactory(
        getAllCardsHallOfFameUseCase: GetAllCardsUseCase,
        updateAllCardsHallOfFameUseCase: UpdateAllCardsUseCase
    ): AllCardsClassicViewModelFactory {
        return AllCardsClassicViewModelFactory(
            getAllCardsHallOfFameUseCase,
            updateAllCardsHallOfFameUseCase
        )
    }
}