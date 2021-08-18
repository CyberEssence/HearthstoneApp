package com.example.hearthstoneapp.presentation.allcards.basic.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hearthstoneapp.data.api.RetrofitService
import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.domain.usecase.GetAllCardsUseCase
import com.example.hearthstoneapp.domain.usecase.UpdateAllCardsUseCase
import com.example.hearthstoneapp.presentation.allcards.AllCardsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AllCardsBasicViewModel(
        private val getAllCardsUseCase: GetAllCardsUseCase,
        private val updateAllCardsUseCase: UpdateAllCardsUseCase
): AllCardsViewModel(getAllCardsUseCase,
    updateAllCardsUseCase) {

    val userService = RetrofitService().getApiClient()
    val allCards = MutableLiveData<List<AllCardsBasic>>()

    fun refresh() {
        fetchUsers()
    }

    private fun fetchUsers() {

        CoroutineScope(Dispatchers.IO).launch {
            val response = userService.getAllCardsBasic()
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