package com.example.hearthstoneapp.presentation.allcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.hearthstoneapp.R
import com.example.hearthstoneapp.databinding.ActivityAllCardsBasicDetailBinding

class AllCardsBasicDetail : AppCompatActivity() {

    private lateinit var binding: ActivityAllCardsBasicDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_cards_basic_detail)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_cards_basic_detail)

        val nameOfBasicCard = intent.getStringExtra("nameOfBasicCard")
        binding.nameOfBasicCard.text = nameOfBasicCard

    }
}