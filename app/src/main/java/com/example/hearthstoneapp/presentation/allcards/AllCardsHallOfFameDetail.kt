package com.example.hearthstoneapp.presentation.allcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.hearthstoneapp.R
import com.example.hearthstoneapp.databinding.ActivityAllCardsClassicDetailBinding
import com.example.hearthstoneapp.databinding.ActivityAllCardsHallOfFameDetailBinding

class AllCardsHallOfFameDetail : AppCompatActivity() {

    private lateinit var binding: ActivityAllCardsHallOfFameDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_cards_hall_of_fame_detail)

        val nameOfHallOfFameCard = intent.getStringExtra("nameOfHallOfFameCard")
        binding.nameOfHallOfFameCard.text = nameOfHallOfFameCard
    }
}