package com.example.hearthstoneapp.presentation.di.allcards

import com.example.hearthstoneapp.domain.usecase.GetAllCardsUseCase
import com.example.hearthstoneapp.domain.usecase.UpdateAllCardsUseCase
import com.example.hearthstoneapp.presentation.allcards.AllCardsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AllCardsModule {
    @AllCardsScope
    @Provides
    fun provideAllCardsViewModelFactory(
        getAllCardsUseCase: GetAllCardsUseCase,
        updateAllCardsUseCase: UpdateAllCardsUseCase
    ): AllCardsViewModelFactory {
        return AllCardsViewModelFactory(
            getAllCardsUseCase,
            updateAllCardsUseCase
        )
    }
}