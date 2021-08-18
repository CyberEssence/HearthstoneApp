package com.example.hearthstoneapp.domain.usecase.halloffame

import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic
import com.example.hearthstoneapp.data.model.allcards.halloffame.AllCardsHallOfFame
import com.example.hearthstoneapp.domain.repository.classic.AllCardsClassicRepository
import com.example.hearthstoneapp.domain.repository.halloffame.AllCardsHallOfFameRepository
import javax.inject.Inject

class GetAllCardsHallOfFameUseCase @Inject constructor(private val allCardsHallOfFameRepository: AllCardsHallOfFameRepository) {
    suspend fun execute(): List<AllCardsHallOfFame>? = allCardsHallOfFameRepository.getAllCardsHallOfFame()
}