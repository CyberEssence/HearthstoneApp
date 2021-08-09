package com.example.hearthstoneapp.presentation.allcards

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hearthstoneapp.R
import com.example.hearthstoneapp.data.api.RetrofitService
import com.example.hearthstoneapp.data.model.AllCards
import com.example.hearthstoneapp.databinding.ListItemBinding
import kotlinx.android.synthetic.main.list_item.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.collections.ArrayList

class AllCardsAdapter(var allCards: ArrayList<AllCards>): RecyclerView.Adapter<MyViewHolder>() {
    private val allCardsList = ArrayList<AllCards>()

    fun setList(allCards: List<AllCards>?){
        allCardsList.clear()
        if (allCards != null) {
            allCardsList.addAll(allCards)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return allCardsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(allCardsList[position])
    }
}



class MyViewHolder(val binding: ListItemBinding):
    RecyclerView.ViewHolder(binding.root){

    private val nameOfCard = binding.nameTextView
    private val nameOfCardSet = binding.cardSetTextView


    fun bind(allCards: AllCards){
        nameOfCard.text = allCards.name
        nameOfCardSet.text = allCards.cardSet
    }

}