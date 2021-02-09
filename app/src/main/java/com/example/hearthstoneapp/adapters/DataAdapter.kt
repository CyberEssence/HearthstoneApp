package com.example.hearthstoneapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.hearthstoneapp.R
import com.example.hearthstoneapp.model.cards.Card


class DataAdapter(val context: Context) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {


    var cards: List<Card> = listOf()
//    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.ViewHolder {
        //context = parent.context
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val imageView = holder.iv_background
//        val card: Card = cards[position]
//        Glide.with(context).load(card.img).into(imageView)
        Glide.with(context).load(cards[position].img)
            .apply(RequestOptions().centerCrop())
            .into(holder.iv_background)
    }

    fun setUsersListItems(cards: List<Card>){
        this.cards = cards.reversed() // Invertir orden de lista con método reversed()
        notifyDataSetChanged()
    }

    override fun getItemCount() = cards.size


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iv_background: ImageView = view.findViewById(R.id.card_background_image) as ImageView
    }
}