package com.example.hearthstoneapp.domain.usecase

import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic
import com.example.hearthstoneapp.data.model.allcards.halloffame.AllCardsHallOfFame
import com.example.hearthstoneapp.domain.repository.basic.AllCardsBasicRepository
import com.example.hearthstoneapp.domain.repository.classic.AllCardsClassicRepository
import com.example.hearthstoneapp.domain.repository.halloffame.AllCardsHallOfFameRepository
import javax.inject.Inject

class GetAllCardsUseCase @Inject constructor(
    private val allCardsBasicRepository: AllCardsBasicRepository,
    private val allCardsClassicRepository: AllCardsClassicRepository,
    private val allCardsHallOfFameRepository: AllCardsHallOfFameRepository
) {
    suspend fun executeClassic(): List<AllCardsClassic>? = allCardsClassicRepository.getAllCardsClassic()
    suspend fun executeBasic(): List<AllCardsBasic>? = allCardsBasicRepository.getAllCardsBasic()
    suspend fun executeHallOfFame(): List<AllCardsHallOfFame>? = allCardsHallOfFameRepository.getAllCardsHallOfFame()
}