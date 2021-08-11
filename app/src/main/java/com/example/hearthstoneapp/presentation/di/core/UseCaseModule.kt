package com.example.hearthstoneapp.presentation.di.core

import com.example.hearthstoneapp.domain.repository.basic.AllCardsBasicRepository
import com.example.hearthstoneapp.domain.repository.classic.AllCardsClassicRepository
import com.example.hearthstoneapp.domain.usecase.basic.GetAllCardsBasicUseCase
import com.example.hearthstoneapp.domain.usecase.basic.UpdateAllCardsBasicUseCase
import com.example.hearthstoneapp.domain.usecase.classic.GetAllCardsClassicUseCase
import com.example.hearthstoneapp.domain.usecase.classic.UpdateAllCardsClassicUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetAllCardBasicUseCase(allCardsBasicRepository: AllCardsBasicRepository): GetAllCardsBasicUseCase {
        return GetAllCardsBasicUseCase(allCardsBasicRepository)
    }
    @Provides
    fun provideUpdateAllCardBasicUseCase(allCardsBasicRepository: AllCardsBasicRepository): UpdateAllCardsBasicUseCase {
        return UpdateAllCardsBasicUseCase(allCardsBasicRepository)
    }

    @Provides
    fun provideGetAllCardClassicUseCase(allCardsClassicRepository: AllCardsClassicRepository): GetAllCardsClassicUseCase {
        return GetAllCardsClassicUseCase(allCardsClassicRepository)
    }
    @Provides
    fun provideUpdateAllCardClassicUseCase(allCardsClassicRepository: AllCardsClassicRepository): UpdateAllCardsClassicUseCase {
        return UpdateAllCardsClassicUseCase(allCardsClassicRepository)
    }
}