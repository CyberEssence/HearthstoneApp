package com.example.hearthstoneapp.presentation.allcards

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.hearthstoneapp.data.api.RetrofitService
import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.domain.usecase.GetAllCardsUseCase
import com.example.hearthstoneapp.domain.usecase.UpdateAllCardsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AllCardsViewModel(
    private val getAllCardsUseCase: GetAllCardsUseCase,
    private val updateAllCardsUseCase: UpdateAllCardsUseCase
): ViewModel() {

    val userService = RetrofitService().getApiClient()
    val allCards = MutableLiveData<List<AllCardsBasic>>()

    fun getAllCards() = liveData {
        val allCardsList = getAllCardsUseCase.execute()
        emit(allCardsList)
    }

    fun updateAllCards() = liveData {
        val allCardsList = updateAllCardsUseCase.execute()
        emit(allCardsList)
    }

    fun refresh() {
        fetchUsers()
    }

    private fun fetchUsers() {

        CoroutineScope(Dispatchers.IO).launch {
            val response = userService.getAllCards()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    allCards.value = response.body()?.basic
                    Log.d("MyTag", response.body().toString())
                } else {
                    Log.e("TagError","Error")
                }
            }
        }
    }

}