package com.example.hearthstoneapp.presentation.allcards.classic

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.hearthstoneapp.data.api.RetrofitService
import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic
import com.example.hearthstoneapp.domain.usecase.classic.GetAllCardsClassicUseCase
import com.example.hearthstoneapp.domain.usecase.classic.UpdateAllCardsClassicUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AllCardsClassicViewModel(
    private val getAllCardsClassicUseCase: GetAllCardsClassicUseCase,
    private val updateAllCardsClassicUseCase: UpdateAllCardsClassicUseCase
): ViewModel() {

    val userService = RetrofitService().getApiClient()
    val allCards = MutableLiveData<List<AllCardsClassic>>()

    fun getAllCardsClassic() = liveData {
        val allCardsList = getAllCardsClassicUseCase.execute()
        emit(allCardsList)
    }

    fun updateAllCardsClassic() = liveData {
        val allCardsList = updateAllCardsClassicUseCase.execute()
        emit(allCardsList)
    }

    fun refresh() {
        fetchUsers()
    }

    private fun fetchUsers() {

        CoroutineScope(Dispatchers.IO).launch {
            val response = userService.getAllCardsClassic()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    allCards.value = response.body()?.classic
                    Log.d("MyTag", response.body().toString())
                } else {
                    Log.e("TagError","Error")
                }
            }
        }
    }

}