package com.example.hearthstoneapp.presentation.allcards

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hearthstoneapp.R
import com.example.hearthstoneapp.data.model.AllCards
import com.example.hearthstoneapp.databinding.ListItemBinding

class AllCardsAdapter(): RecyclerView.Adapter<MyViewHolder>() {
    private val allCardsList = ArrayList<AllCards>()

    fun setList(allCards: List<AllCards>){
        allCardsList.clear()
        allCardsList.addAll(allCards)
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

    fun bind(allCards: AllCards){
        binding.nameTextView.text = allCards.name
        binding.cardSetTextView.text = allCards.cardSet
    }

}