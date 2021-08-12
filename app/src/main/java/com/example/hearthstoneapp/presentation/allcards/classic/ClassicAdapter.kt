package com.example.hearthstoneapp.presentation.allcards.classic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hearthstoneapp.R
import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic
import com.example.hearthstoneapp.databinding.ListItemClassicBinding

class ClassicAdapter(): RecyclerView.Adapter<ClassicViewHolder>() {
    private val allCardsList = ArrayList<AllCardsClassic>()

    fun setList(allCardClassic: List<AllCardsClassic>?){
        allCardsList.clear()
        if (allCardClassic != null) {
            allCardsList.addAll(allCardClassic)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassicViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemClassicBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item_classic,
            parent,
            false
        )
        return ClassicViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return allCardsList.size
    }

    override fun onBindViewHolder(holder: ClassicViewHolder, position: Int) {
        holder.bind(allCardsList[position])
    }
}



class ClassicViewHolder(binding: ListItemClassicBinding):
    RecyclerView.ViewHolder(binding.root){

    private val nameOfCard = binding.nameTextViewClassic
    private val nameOfCardSet = binding.cardSetTextViewClassic


    fun bind(allCardsClassic: AllCardsClassic){
        nameOfCard.text = allCardsClassic.name
        nameOfCardSet.text = allCardsClassic.cardSet
    }

}