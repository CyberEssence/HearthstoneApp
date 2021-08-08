package com.example.hearthstoneapp.presentation.allcards

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hearthstoneapp.R
import com.example.hearthstoneapp.databinding.ActivityAllCardsBinding
import com.example.hearthstoneapp.presentation.di.Injector
import javax.inject.Inject

class AllCardsActivity: AppCompatActivity() {
    @Inject
    lateinit var factory: AllCardsViewModelFactory
    private lateinit var allCardsViewModel: AllCardsViewModel
    private lateinit var adapter: AllCardsAdapter
    private lateinit var binding: ActivityAllCardsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_cards)
        (application as Injector).createAllCardsSubComponent()
            .inject(this)

        allCardsViewModel= ViewModelProvider(this,factory)
            .get(AllCardsViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.allCardsRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = AllCardsAdapter()
        binding.allCardsRecyclerView.adapter = adapter
        displayPopularArtists()
    }

    private fun displayPopularArtists(){
        binding.allCardsProgressBar.visibility = View.VISIBLE
        val responseLiveData = allCardsViewModel.getAllCards()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.allCardsProgressBar.visibility = View.GONE
            }else{
                binding.allCardsProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }
}