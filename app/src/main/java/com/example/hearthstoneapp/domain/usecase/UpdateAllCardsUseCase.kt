package com.example.hearthstoneapp.domain.usecase

import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic
import com.example.hearthstoneapp.domain.repository.basic.AllCardsBasicRepository
import com.example.hearthstoneapp.domain.repository.classic.AllCardsClassicRepository

class UpdateAllCardsUseCase(
    private val allCardsBasicRepository: AllCardsBasicRepository,
    private val allCardsClassicRepository: AllCardsClassicRepository
) {
    suspend fun executeClassic():List<AllCardsClassic>? = allCardsClassicRepository.updateAllCardsClassic()
    suspend fun executeBasic():List<AllCardsBasic>? = allCardsBasicRepository.updateAllCardsBasic()
}