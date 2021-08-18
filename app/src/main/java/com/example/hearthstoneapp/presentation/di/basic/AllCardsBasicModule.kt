package com.example.hearthstoneapp.presentation.di.basic

import com.example.hearthstoneapp.domain.usecase.GetAllCardsUseCase
import com.example.hearthstoneapp.domain.usecase.UpdateAllCardsUseCase
import com.example.hearthstoneapp.presentation.allcards.basic.viewmodel.AllCardsBasicViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AllCardsBasicModule {
    @AllCardsBasicScope
    @Provides
    fun provideAllCardsViewModelFactory(
        getAllCardsBasicUseCase: GetAllCardsUseCase,
        updateAllCardsBasicUseCase: UpdateAllCardsUseCase
    ): AllCardsBasicViewModelFactory {
        return AllCardsBasicViewModelFactory(
            getAllCardsBasicUseCase,
            updateAllCardsBasicUseCase
        )
    }
}