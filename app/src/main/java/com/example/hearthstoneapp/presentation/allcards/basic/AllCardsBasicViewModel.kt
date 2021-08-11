package com.example.hearthstoneapp.presentation.allcards.basic

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.hearthstoneapp.data.api.RetrofitService
import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.domain.usecase.basic.GetAllCardsBasicUseCase
import com.example.hearthstoneapp.domain.usecase.basic.UpdateAllCardsBasicUseCase
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AllCardsBasicViewModel(
    private val getAllCardsBasicUseCase: GetAllCardsBasicUseCase,
    private val updateAllCardsBasicUseCase: UpdateAllCardsBasicUseCase
): ViewModel() {

    val userService = RetrofitService().getApiClient()
    val allCards = MutableLiveData<List<AllCardsBasic>>()

    fun getAllCardsBasic() = liveData {
        val allCardsList = getAllCardsBasicUseCase.execute()
        emit(allCardsList)
    }

    fun updateAllCardsBasic() = liveData {
        val allCardsList = updateAllCardsBasicUseCase.execute()
        emit(allCardsList)
    }

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