package com.example.hearthstoneapp.presentation.allcards

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hearthstoneapp.R
import com.example.hearthstoneapp.data.model.AllCards
import com.example.hearthstoneapp.databinding.ListItemBinding
import kotlin.collections.ArrayList

class AllCardsAdapter(var allCards: ArrayList<AllCards>, val context: Context): RecyclerView.Adapter<MyViewHolder>() {
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



class MyViewHolder(binding: ListItemBinding):
    RecyclerView.ViewHolder(binding.root){

    private val nameOfCard = binding.nameTextView
    private val nameOfCardSet = binding.cardSetTextView


    fun bind(allCards: AllCards){
        nameOfCard.text = allCards.name
        nameOfCardSet.text = allCards.cardSet
    }

}