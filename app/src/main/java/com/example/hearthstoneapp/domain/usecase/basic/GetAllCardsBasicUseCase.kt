package com.example.hearthstoneapp.domain.usecase.basic

import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.domain.repository.basic.AllCardsBasicRepository
import javax.inject.Inject

class GetAllCardsBasicUseCase @Inject constructor(private val allCardsBasicRepository: AllCardsBasicRepository) {
    suspend fun execute(): List<AllCardsBasic>? = allCardsBasicRepository.getAllCardsBasic()
}