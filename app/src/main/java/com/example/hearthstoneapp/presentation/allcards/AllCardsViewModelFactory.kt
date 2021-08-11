package com.example.hearthstoneapp.presentation.allcards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hearthstoneapp.domain.usecase.GetAllCardsUseCase
import com.example.hearthstoneapp.domain.usecase.UpdateAllCardsUseCase

open class AllCardsViewModelFactory(
    private val getAllCardsUseCase: GetAllCardsUseCase,
    private val updateAllCardsUseCase: UpdateAllCardsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AllCardsViewModel(
            getAllCardsUseCase,
            updateAllCardsUseCase
        ) as T
    }
}