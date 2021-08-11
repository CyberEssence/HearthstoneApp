package com.example.hearthstoneapp.domain.usecase.basic

import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.domain.repository.basic.AllCardsBasicRepository

class GetAllCardsBasicUseCase (private val allCardsBasicRepository: AllCardsBasicRepository) {
    suspend fun execute(): List<AllCardsBasic>? = allCardsBasicRepository.getAllCardsBasic()
}