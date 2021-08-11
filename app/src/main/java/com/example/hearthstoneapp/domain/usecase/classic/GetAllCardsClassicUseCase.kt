package com.example.hearthstoneapp.domain.usecase.classic

import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic
import com.example.hearthstoneapp.domain.repository.basic.AllCardsBasicRepository
import com.example.hearthstoneapp.domain.repository.classic.AllCardsClassicRepository

class GetAllCardsClassicUseCase (private val allCardsClassicRepository: AllCardsClassicRepository) {
    suspend fun execute(): List<AllCardsClassic>? = allCardsClassicRepository.getAllCardsClassic()
}