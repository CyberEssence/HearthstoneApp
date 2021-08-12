package com.example.hearthstoneapp.presentation.allcards.basic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hearthstoneapp.domain.usecase.GetAllCardsUseCase
import com.example.hearthstoneapp.domain.usecase.UpdateAllCardsUseCase
import com.example.hearthstoneapp.domain.usecase.basic.GetAllCardsBasicUseCase
import com.example.hearthstoneapp.domain.usecase.basic.UpdateAllCardsBasicUseCase
import com.example.hearthstoneapp.presentation.allcards.AllCardsViewModel
import com.example.hearthstoneapp.presentation.allcards.AllCardsViewModelFactory

class AllCardsBasicViewModelFactory(
    private val getAllCardsUseCase: GetAllCardsUseCase,
    private val updateAllCardsUseCase: UpdateAllCardsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AllCardsBasicViewModel(
            getAllCardsUseCase,
            updateAllCardsUseCase
        ) as T
    }
}