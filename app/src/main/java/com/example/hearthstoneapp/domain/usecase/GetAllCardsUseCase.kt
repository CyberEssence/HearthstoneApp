package com.example.hearthstoneapp.domain.usecase

import com.example.hearthstoneapp.data.model.AllCards
import com.example.hearthstoneapp.domain.repository.AllCardsRepository

class GetAllCardsUseCase (private val allCardsRepository: AllCardsRepository) {
    suspend fun execute(): List<AllCards>? = allCardsRepository.getAllCards()
}