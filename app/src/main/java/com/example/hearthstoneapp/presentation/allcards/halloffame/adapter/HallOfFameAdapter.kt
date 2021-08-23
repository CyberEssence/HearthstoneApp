package com.example.hearthstoneapp.presentation.allcards.halloffame.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hearthstoneapp.R
import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic
import com.example.hearthstoneapp.data.model.allcards.halloffame.AllCardsHallOfFame
import com.example.hearthstoneapp.databinding.ListItemHallOfFameBinding
import com.example.hearthstoneapp.presentation.allcards.OnAllCardsClassicRecyclerViewClickListener
import com.example.hearthstoneapp.presentation.allcards.OnAllCardsHallOfFameRecyclerViewClickListener

class HallOfFameAdapter(
    private val allCardsList: ArrayList<AllCardsHallOfFame>,
    private val onAllCardsHallOfFameRecyclerViewClickListener: OnAllCardsHallOfFameRecyclerViewClickListener
    ): RecyclerView.Adapter<HallOfFameViewHolder>() {

    fun setList(allCardHallOfFame: List<AllCardsHallOfFame>?){
        allCardsList.clear()
        if (allCardHallOfFame != null) {
            allCardsList.addAll(allCardHallOfFame)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HallOfFameViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemHallOfFameBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item_hall_of_fame,
            parent,
            false
        )
        return HallOfFameViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return allCardsList.size
    }

    override fun onBindViewHolder(holder: HallOfFameViewHolder, position: Int) {
        holder.bind(allCardsList[position])

        holder.itemView.setOnClickListener {
            onAllCardsHallOfFameRecyclerViewClickListener.onAllCardsHallOfFameItemClicked(position)
        }
    }
}



class HallOfFameViewHolder(binding: ListItemHallOfFameBinding):
    RecyclerView.ViewHolder(binding.root){

    private val nameOfCard = binding.nameTextViewHallOfFame
    private val nameOfCardSet = binding.cardSetTextViewHallOfFame


    fun bind(allCardsHallOfFame: AllCardsHallOfFame){
        nameOfCard.text = allCardsHallOfFame.name
        nameOfCardSet.text = allCardsHallOfFame.cardSet
    }

}