package com.example.hearthstoneapp.presentation.allcards.halloffame.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hearthstoneapp.data.api.RetrofitService
import com.example.hearthstoneapp.data.model.allcards.halloffame.AllCardsHallOfFame
import com.example.hearthstoneapp.domain.usecase.GetAllCardsUseCase
import com.example.hearthstoneapp.domain.usecase.UpdateAllCardsUseCase
import com.example.hearthstoneapp.presentation.allcards.AllCardsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AllCardsHallOfFameViewModel(
    private val getAllCardsUseCase: GetAllCardsUseCase,
    private val updateAllCardsUseCase: UpdateAllCardsUseCase
): AllCardsViewModel(getAllCardsUseCase,
    updateAllCardsUseCase)  {

    val userService = RetrofitService().getApiClient()
    val allCards = MutableLiveData<List<AllCardsHallOfFame>>()

    fun refresh() {
        fetchUsers()
    }

    private fun fetchUsers() {

        CoroutineScope(Dispatchers.IO).launch {
            val response = userService.getAllCardsHallOfFame()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    allCards.value = response.body()?.hallOfFame
                    Log.d("MyTag", response.body().toString())
                } else {
                    Log.e("TagError","Error")
                }
            }
        }
    }

}