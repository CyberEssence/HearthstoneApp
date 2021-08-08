package com.example.hearthstoneapp.presentation.allcards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.hearthstoneapp.domain.usecase.GetAllCardsUseCase
import com.example.hearthstoneapp.domain.usecase.UpdateAllCardsUseCase

class AllCardsViewModel(
    private val getAllCardsUseCase: GetAllCardsUseCase,
    private val updateAllCardsUseCase: UpdateAllCardsUseCase
): ViewModel() {

    fun getAllCards() = liveData {
        val allCardsList = getAllCardsUseCase.execute()
        emit(allCardsList)
    }

    fun updateAllCards() = liveData {
        val allCardsList = updateAllCardsUseCase.execute()
        emit(allCardsList)
    }

}