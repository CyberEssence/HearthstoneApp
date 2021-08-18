package com.example.hearthstoneapp.domain.usecase

import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic
import com.example.hearthstoneapp.data.model.allcards.halloffame.AllCardsHallOfFame
import com.example.hearthstoneapp.domain.repository.basic.AllCardsBasicRepository
import com.example.hearthstoneapp.domain.repository.classic.AllCardsClassicRepository
import com.example.hearthstoneapp.domain.repository.halloffame.AllCardsHallOfFameRepository
import javax.inject.Inject

class UpdateAllCardsUseCase @Inject constructor(
    private val allCardsBasicRepository: AllCardsBasicRepository,
    private val allCardsClassicRepository: AllCardsClassicRepository,
    private val allCardsHallOfFameRepository: AllCardsHallOfFameRepository
) {
    suspend fun executeClassic():List<AllCardsClassic>? = allCardsClassicRepository.updateAllCardsClassic()
    suspend fun executeBasic():List<AllCardsBasic>? = allCardsBasicRepository.updateAllCardsBasic()
    suspend fun executeHallOfFame():List<AllCardsHallOfFame>? = allCardsHallOfFameRepository.updateAllCardsHallOfFame()
}