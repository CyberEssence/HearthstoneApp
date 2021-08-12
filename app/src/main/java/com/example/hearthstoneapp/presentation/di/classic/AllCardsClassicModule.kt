package com.example.hearthstoneapp.presentation.di.classic

import com.example.hearthstoneapp.domain.usecase.GetAllCardsUseCase
import com.example.hearthstoneapp.domain.usecase.UpdateAllCardsUseCase
import com.example.hearthstoneapp.presentation.allcards.classic.AllCardsClassicViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AllCardsClassicModule {
    @AllCardsClassicScope
    @Provides
    fun provideAllCardsClassicViewModelFactory(
        getAllCardsClassicUseCase: GetAllCardsUseCase,
        updateAllCardsClassicUseCase: UpdateAllCardsUseCase
    ): AllCardsClassicViewModelFactory {
        return AllCardsClassicViewModelFactory(
            getAllCardsClassicUseCase,
            updateAllCardsClassicUseCase
        )
    }
}