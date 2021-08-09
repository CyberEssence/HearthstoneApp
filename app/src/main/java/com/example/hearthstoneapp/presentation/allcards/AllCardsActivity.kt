package com.example.hearthstoneapp.presentation.allcards

import android.os.Bundle
import android.util.Log
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
import com.example.hearthstoneapp.data.api.HearthstoneService
import com.example.hearthstoneapp.data.api.RetrofitService
import com.example.hearthstoneapp.data.model.AllCards
import com.example.hearthstoneapp.databinding.ActivityAllCardsBinding
import com.example.hearthstoneapp.presentation.di.Injector
import kotlinx.android.synthetic.main.activity_all_cards.*
import kotlinx.android.synthetic.main.list_item.view.*
import kotlinx.coroutines.*
import retrofit2.HttpException
import retrofit2.await
import java.io.IOException
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class AllCardsActivity: AppCompatActivity() {
    @Inject
    lateinit var factory: AllCardsViewModelFactory
    private lateinit var allCardsViewModel: AllCardsViewModel
    private lateinit var adapter: AllCardsAdapter
    private lateinit var binding: ActivityAllCardsBinding
    private val allCardsList = ArrayList<AllCards>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_cards)
        (application as Injector).createAllCardsSubComponent()
            .inject(this)

        allCardsViewModel= ViewModelProvider(this,factory)
            .get(AllCardsViewModel::class.java)


        binding.allCardsRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.allCardsRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = AllCardsAdapter(allCardsList, applicationContext)
        binding.allCardsRecyclerView.adapter = adapter
        displayAllCards()
    }

    private fun displayAllCards(){
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateAllCards()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateAllCards(){
        binding.allCardsProgressBar.visibility = View.VISIBLE
        val response = allCardsViewModel.updateAllCards()
        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.allCardsProgressBar.visibility = View.GONE
            }else{
                binding.allCardsProgressBar.visibility = View.GONE
            }
        })
    }
}