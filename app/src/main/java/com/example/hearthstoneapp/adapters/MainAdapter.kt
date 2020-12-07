package com.example.hearthstoneapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hearthstoneapp.R
import kotlinx.android.synthetic.main.custom_item_spinner_class.view.*

class MainAdapter(val list: ArrayList<String>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.custom_item_spinner_class, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = list.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.class_text.text = list[position]
    }

}