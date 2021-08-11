package com.example.hearthstoneapp.presentation.di.classic

import com.example.hearthstoneapp.domain.usecase.classic.GetAllCardsClassicUseCase
import com.example.hearthstoneapp.domain.usecase.classic.UpdateAllCardsClassicUseCase
import com.example.hearthstoneapp.presentation.allcards.basic.AllCardsBasicViewModelFactory
import com.example.hearthstoneapp.presentation.allcards.classic.AllCardsClassicViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AllCardsClassicModule {
    @AllCardsClassicScope
    @Provides
    fun provideAllCardsClassicViewModelFactory(
        getAllCardsClassicUseCase: GetAllCardsClassicUseCase,
        updateAllCardsClassicUseCase: UpdateAllCardsClassicUseCase
    ): AllCardsClassicViewModelFactory {
        return AllCardsClassicViewModelFactory(
            getAllCardsClassicUseCase,
            updateAllCardsClassicUseCase
        )
    }
}