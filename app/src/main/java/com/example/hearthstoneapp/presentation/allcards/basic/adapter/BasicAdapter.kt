package com.example.hearthstoneapp.presentation.allcards.basic.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hearthstoneapp.R
import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.databinding.ListItemBasicBinding
import com.example.hearthstoneapp.presentation.allcards.OnAllCardsBasicRecyclerViewClickListener
import kotlin.collections.ArrayList

class BasicAdapter(
    private val allCardsList: ArrayList<AllCardsBasic>,
    private val onAllCardsBasicRecyclerViewClickListener:
    OnAllCardsBasicRecyclerViewClickListener
    ):
    RecyclerView.Adapter<BasicViewHolder>() {

    fun setList(allCardBasics: List<AllCardsBasic>?){
        allCardsList.clear()
        if (allCardBasics != null) {
            allCardsList.addAll(allCardBasics)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBasicBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item_basic,
            parent,
            false
        )
        return BasicViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return allCardsList.size
    }

    override fun onBindViewHolder(holder: BasicViewHolder, position: Int) {
        holder.bind(allCardsList[position])

        holder.itemView.setOnClickListener {
            onAllCardsBasicRecyclerViewClickListener.onAllCardsBasicItemClicked(position)
        }
    }
}



class BasicViewHolder(binding: ListItemBasicBinding):
    RecyclerView.ViewHolder(binding.root){

    private val nameOfCard = binding.nameTextView
    private val nameOfCardSet = binding.cardSetTextView


    fun bind(allCardsBasic: AllCardsBasic){
        nameOfCard.text = allCardsBasic.name
        nameOfCardSet.text = allCardsBasic.cardSet
    }

}