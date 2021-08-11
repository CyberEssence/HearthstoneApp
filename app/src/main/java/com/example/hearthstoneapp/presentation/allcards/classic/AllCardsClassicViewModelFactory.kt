package com.example.hearthstoneapp.presentation.allcards.classic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hearthstoneapp.domain.usecase.basic.GetAllCardsBasicUseCase
import com.example.hearthstoneapp.domain.usecase.basic.UpdateAllCardsBasicUseCase
import com.example.hearthstoneapp.domain.usecase.classic.GetAllCardsClassicUseCase
import com.example.hearthstoneapp.domain.usecase.classic.UpdateAllCardsClassicUseCase
import com.example.hearthstoneapp.presentation.allcards.basic.AllCardsBasicViewModel
import javax.inject.Inject

class AllCardsClassicViewModelFactory(
    private val getAllCardsClassicUseCase: GetAllCardsClassicUseCase,
    private val updateAllCardsClassicUseCase: UpdateAllCardsClassicUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AllCardsClassicViewModel(
            getAllCardsClassicUseCase,
            updateAllCardsClassicUseCase
        ) as T
    }
}