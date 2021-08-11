package com.example.hearthstoneapp.presentation.allcards.classic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hearthstoneapp.domain.usecase.GetAllCardsUseCase
import com.example.hearthstoneapp.domain.usecase.UpdateAllCardsUseCase
import com.example.hearthstoneapp.presentation.allcards.AllCardsViewModel

class AllCardsClassicViewModelFactory(
    private val getAllCardsUseCase: GetAllCardsUseCase,
    private val updateAllCardsUseCase: UpdateAllCardsUseCase
): AllCardsViewModel(
    getAllCardsUseCase,
    updateAllCardsUseCase
), ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AllCardsViewModel(
            getAllCardsUseCase,
            updateAllCardsUseCase
        ) as T
    }
}