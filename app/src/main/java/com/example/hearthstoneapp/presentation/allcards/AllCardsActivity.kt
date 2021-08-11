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
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hearthstoneapp.R
import com.example.hearthstoneapp.data.model.allcards.basic.AllCardsBasic
import com.example.hearthstoneapp.data.model.allcards.classic.AllCardsClassic
import com.example.hearthstoneapp.databinding.ActivityAllCardsBinding
import com.example.hearthstoneapp.presentation.allcards.basic.AllCardsBasicViewModel
import com.example.hearthstoneapp.presentation.allcards.basic.AllCardsBasicViewModelFactory
import com.example.hearthstoneapp.presentation.allcards.classic.AllCardsClassicViewModel
import com.example.hearthstoneapp.presentation.allcards.classic.AllCardsClassicViewModelFactory
import com.example.hearthstoneapp.presentation.di.Injector
import javax.inject.Inject
import kotlin.collections.ArrayList

class AllCardsActivity: AppCompatActivity() {
    @Inject
    lateinit var factoryBasic: AllCardsBasicViewModelFactory
    @Inject
    lateinit var factoryClassic: AllCardsClassicViewModelFactory
    private lateinit var allCardsBasicViewModel: AllCardsBasicViewModel
    private lateinit var allCardsClassicViewModel: AllCardsClassicViewModel
    private var basicAdapter: BasicAdapter = BasicAdapter()
    private var classicAdapter: ClassicAdapter = ClassicAdapter()
    private lateinit var binding: ActivityAllCardsBinding
    private val concatAdapter = ConcatAdapter(basicAdapter, classicAdapter)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_cards)
        (application as Injector).createAllCardsBasicSubComponent()
            .inject(this)

        (application as Injector).createAllCardsClassicSubComponent()
            .inject(this)

        allCardsBasicViewModel = ViewModelProvider(this,factoryBasic)
            .get(AllCardsBasicViewModel::class.java)
        allCardsClassicViewModel = ViewModelProvider(this,factoryClassic)
            .get(AllCardsClassicViewModel::class.java)


        binding.allCardsRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.allCardsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.allCardsRecyclerView.adapter = concatAdapter
        displayAllCards()
    }

    private fun displayAllCards(){
        binding.allCardsProgressBar.visibility = View.VISIBLE
        val responseLiveDataBasic = allCardsBasicViewModel.getAllCardsBasic()
        val responseLiveDataClassic = allCardsClassicViewModel.getAllCardsClassic()
        responseLiveDataBasic.observe(this, Observer {
            if(it!=null){
                basicAdapter.setList(it)
                basicAdapter.notifyDataSetChanged()
                binding.allCardsProgressBar.visibility = View.GONE
            }else{
                binding.allCardsProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })

        responseLiveDataClassic.observe(this, Observer {
            if(it!=null){
                classicAdapter.setList(it)
                classicAdapter.notifyDataSetChanged()
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
        val responseBasic = allCardsBasicViewModel.updateAllCardsBasic()
        val responseClassic = allCardsClassicViewModel.updateAllCardsClassic()
        responseBasic.observe(this, Observer {
            if(it!=null){
                basicAdapter.setList(it)
                basicAdapter.notifyDataSetChanged()
                binding.allCardsProgressBar.visibility = View.GONE
            }else{
                binding.allCardsProgressBar.visibility = View.GONE
            }
        })
        responseClassic.observe(this, Observer {
            if(it!=null){
                classicAdapter.setList(it)
                classicAdapter.notifyDataSetChanged()
                binding.allCardsProgressBar.visibility = View.GONE
            }else{
                binding.allCardsProgressBar.visibility = View.GONE
            }
        })
    }
}