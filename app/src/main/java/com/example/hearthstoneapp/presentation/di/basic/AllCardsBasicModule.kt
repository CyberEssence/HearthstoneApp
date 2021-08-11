package com.example.hearthstoneapp.presentation.di.basic

import com.example.hearthstoneapp.domain.usecase.basic.GetAllCardsBasicUseCase
import com.example.hearthstoneapp.domain.usecase.basic.UpdateAllCardsBasicUseCase
import com.example.hearthstoneapp.presentation.allcards.basic.AllCardsBasicViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AllCardsBasicModule {
    @AllCardsBasicScope
    @Provides
    fun provideAllCardsViewModelFactory(
        getAllCardsBasicUseCase: GetAllCardsBasicUseCase,
        updateAllCardsBasicUseCase: UpdateAllCardsBasicUseCase
    ): AllCardsBasicViewModelFactory {
        return AllCardsBasicViewModelFactory(
            getAllCardsBasicUseCase,
            updateAllCardsBasicUseCase
        )
    }
}