package com.example.hearthstoneapp.presentation.allcards

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hearthstoneapp.R
import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.databinding.ListItemBinding
import kotlin.collections.ArrayList

class AllCardsAdapter(var allCardBasics: ArrayList<AllCardsBasic>, val context: Context): RecyclerView.Adapter<MyViewHolder>() {
    private val allCardsList = ArrayList<AllCardsBasic>()

    fun setList(allCardBasics: List<AllCardsBasic>?){
        allCardsList.clear()
        if (allCardBasics != null) {
            allCardsList.addAll(allCardBasics)
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


    fun bind(allCardsBasic: AllCardsBasic){
        nameOfCard.text = allCardsBasic.name
        nameOfCardSet.text = allCardsBasic.cardSet
    }

}