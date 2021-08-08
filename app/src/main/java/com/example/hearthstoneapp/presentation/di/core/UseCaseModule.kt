package com.example.hearthstoneapp.presentation.di.core

import com.example.hearthstoneapp.domain.repository.AllCardsRepository
import com.example.hearthstoneapp.domain.usecase.GetAllCardsUseCase
import com.example.hearthstoneapp.domain.usecase.UpdateAllCardsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetAllCardUseCase(allCardsRepository: AllCardsRepository): GetAllCardsUseCase{
        return GetAllCardsUseCase(allCardsRepository)
    }
    @Provides
    fun provideUpdateAllCardUseCase(allCardsRepository: AllCardsRepository): UpdateAllCardsUseCase{
        return UpdateAllCardsUseCase(allCardsRepository)
    }
}