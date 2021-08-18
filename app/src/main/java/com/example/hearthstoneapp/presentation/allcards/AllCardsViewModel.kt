package com.example.hearthstoneapp.presentation.allcards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.hearthstoneapp.domain.usecase.GetAllCardsUseCase
import com.example.hearthstoneapp.domain.usecase.UpdateAllCardsUseCase

open class AllCardsViewModel(
    private val getAllCardsUseCase: GetAllCardsUseCase,
    private val updateAllCardsUseCase: UpdateAllCardsUseCase
): ViewModel() {
    fun getAllCardsBasic() = liveData {
        val allCardsList = getAllCardsUseCase.executeBasic()
        emit(allCardsList)
    }

    fun updateAllCardsBasic() = liveData {
        val allCardsList = updateAllCardsUseCase.executeBasic()
        emit(allCardsList)
    }

    fun getAllCardsClassic() = liveData {
        val allCardsList = getAllCardsUseCase.executeClassic()
        emit(allCardsList)
    }

    fun updateAllCardsClassic() = liveData {
        val allCardsList = updateAllCardsUseCase.executeClassic()
        emit(allCardsList)
    }

    fun getAllCardsHallOfFame() = liveData {
        val allCardsList = getAllCardsUseCase.executeHallOfFame()
        emit(allCardsList)
    }

    fun updateAllCardsHallOfFame() = liveData {
        val allCardsList = updateAllCardsUseCase.executeHallOfFame()
        emit(allCardsList)
    }

}