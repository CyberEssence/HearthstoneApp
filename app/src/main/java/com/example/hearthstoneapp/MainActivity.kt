package com.example.hearthstoneapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.hearthstoneapp.data.api.RetrofitService
import com.example.hearthstoneapp.data.model.AllCards
import com.example.hearthstoneapp.data.model.Basic
import com.example.hearthstoneapp.databinding.ActivityMainBinding
import com.example.hearthstoneapp.presentation.allcards.AllCardsActivity
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    private var basics = ArrayList<AllCards>()
    var basic : Basic = Basic(basics)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.allCardsButton.setOnClickListener {
            val intent = Intent(this,AllCardsActivity::class.java)
            startActivity(intent)
            RetrofitService().sendNetworkRequest(basics)
        }
    }
}