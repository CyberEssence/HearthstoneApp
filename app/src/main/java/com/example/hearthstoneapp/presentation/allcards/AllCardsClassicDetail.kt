package com.example.hearthstoneapp.presentation.allcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.hearthstoneapp.R
import com.example.hearthstoneapp.databinding.ActivityAllCardsBasicDetailBinding
import com.example.hearthstoneapp.databinding.ActivityAllCardsClassicDetailBinding

class AllCardsClassicDetail : AppCompatActivity() {

    private lateinit var binding: ActivityAllCardsClassicDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_cards_classic_detail)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_cards_classic_detail)

        val nameOfClassicCard = intent.getStringExtra("nameOfClassicCard")
        binding.nameOfClassicCard.text = nameOfClassicCard
    }
}