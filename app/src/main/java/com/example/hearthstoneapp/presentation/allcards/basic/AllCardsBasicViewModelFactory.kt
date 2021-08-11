package com.example.hearthstoneapp.presentation.allcards.basic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hearthstoneapp.domain.usecase.basic.GetAllCardsBasicUseCase
import com.example.hearthstoneapp.domain.usecase.basic.UpdateAllCardsBasicUseCase
import javax.inject.Inject

class AllCardsBasicViewModelFactory(
    private val getAllCardsBasicUseCase: GetAllCardsBasicUseCase,
    private val updateAllCardsBasicUseCase: UpdateAllCardsBasicUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AllCardsBasicViewModel(
            getAllCardsBasicUseCase,
            updateAllCardsBasicUseCase
        ) as T
    }
}